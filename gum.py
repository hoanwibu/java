import urllib.request
from bs4 import BeautifulSoup
import argparse
import os


def download_files(download_folder):
    base_url = "<The base url with /r/>"
    with urllib.request.urlopen(base_url) as url:
        s = url.read()

    soup = BeautifulSoup(s, "html.parser")
    buttons = soup.body.find_all(attrs={"class": "button"})

    # Skip first one, its just a manual.
    for button in buttons:
        if "Download" in button.text:
            # Find the h4 tag in the previous div
            h4_tag = (
                button.find_previous("div")
                .find_previous("div")
                .find("h4")
                .text.lower()
                .replace(" ", "_")
                .replace(",", "")
            )
            if h4_tag:
                file_name = f"{h4_tag}.zip"
                print(f"Downloading {file_name}")
                file_url = base_url + "/" + button["data-resource-id"]
                file_path = os.path.join(download_folder, file_name)
                urllib.request.urlretrieve(file_url, file_path)
                print(f"Downloaded {file_path}")


if __name__ == "__main__":
    parser = argparse.ArgumentParser(
        description="Download files to a specified folder."
    )
    parser.add_argument(
        "download_folder", type=str, help="Folder path to download files"
    )
    args = parser.parse_args()

    download_files(args.download_folder)