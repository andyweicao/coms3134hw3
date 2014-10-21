Wei Cao(wc2467)

1. Compile the files by typing "javac *.java". It may take couple seconds for the first time compilation.
2. Run the programm by typing "java MainProgram [dictionary1] [dictionary2] [file for check]".
   
   [dictionary1] and [dictionary2] are both dictionary text files. Here you can use "words.txt" which is the big dictionary provided by professor as [dictionary1] and "my.txt" which is a small dictionary made by myself as [dictionary2]. For the check file, you can either use my file named "test.txt" or your own file. In the "test.txt", I copied some paragraphs from the Internet and changed some letters in some words to make them misspelled arbitarily. So you can see the result after typing the running command like "java MainProgram words.txt my.txt test.txt".
   
   
   
   The spell checker and corrections work perfectly. You will see the misspelled words with their possible correction words by correcting them using any of the following rules: 
   a. Add one character.
   b. Remove one character.
   c. Exchange adjacent characters.  