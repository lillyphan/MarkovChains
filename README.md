# MarkovChains

ArrayDictionary is a Java class that creates a chain trained on a user-inputted text file and outputs a String imitating the diction of the file.

MarkovChains uses a HashMap to store hashed words as keys and their corresponding words as values to generate a String.
The chain picks a random starting word and continues to pull words out of the HashMap until the end of a sentence,
It then starts again until word count requested by the user is reached.


To use this project, download MarkovChains and a text file.