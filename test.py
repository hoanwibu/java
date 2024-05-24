import time

# Define the alphabet and the message
alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
message = "ITS FINALLY MAY"

# Convert the message to uppercase
message_upper = message.upper()

# Loop through each character in the message
for i in range(len(message_upper) + 1):
    # Loop through each letter in the alphabet
    for j in range(len(alphabet)):
        # Break the loop if we've reached the length of the message
        if j == len(message_upper):
            break
        # Construct the string with the current letter and the rest of the message
        prefix = alphabet[j]
        current_str = prefix + message_upper[j-1:]
        # Print the current string
        print(current_str)
        # Sleep for a short time to simulate typing
        time.sleep(0.04)
# Print the final message
print(message_upper)