# Caesar-Cipher
This is an implementation of the Caesar Cipher. Caesar Cipher is an encryption method where we have a key, and then we replace each alphabet with the alphabet that is key places ahead of it.
For example if we have a key of 3, the 'A' gets replaced by 'D', 'B' gets replaced by 'E' and 'Z' gets replaced by 'C'.

This project however has two different types of encryptions : a one key encryption and a two key encryption. With the former we encrypt every letter of the given String with the given key. In the two key encryption, we encrypt every next element in the string with one key.
It also includes the decrypt methods for both the approaches. However these decrypt methods need the keys to decrypt the strings. This project also includes a breaker method that can break the Caesar Cipher in one or two key encryptions without any key.
