# Linked List Application (SLL)
- Java program for a simple version of the “Wheel of Fortune” (Çarkıfelek) game.
- The main aim of the game is to solve the word puzzle and gain money as you can.
## Description About the Game
- There is only one player.
- The game is played with a special wheel that determines the dollar value of the called letters. The wheel is split into 10 segments as
follows: 10, 20, 30, 40, 100, 200, 300, 400, Bankrupt, and Bankrupt.
- The computer randomly determines a word and then a player tries to guess it by suggesting letters. The word should be an animal in
English such as dog, cat, chicken, penguin, etc.
- The letters of the hidden word represented by tiles are face down. A player spins the wheel by naming the letters one-by-one to
solve the puzzle. Both consonants and vowels can be guessed by the player after spinning the wheel. If the player guesses a letter
that is part of the word, the computer writes it in all its correct positions. If the called letter cannot be found in the word, the player
cannot earn any money from this turn.
- Before guessing a letter, a player must spin the wheel to determine how much each letter, if revealed. Every spin is risky because
the wheel also includes bankrupt, resulting in the loss of all earnings to that point.
- The game is over when the player completes the whole word correctly. The player gets the money he/she earns.
## Initially
1.Read the unsorted file “animals.txt” and then create a Single Linked List (SLL1), which is sorted alphabetically. <br>
2.Add all letters in a Single Linked List (SLL2). <br>
3.Read the unsorted file “HighScoreTable.txt” and create a sorted Single Linked List (SLL3).
## The Beginnig Of The Game
- Generate a random number (x), print this number on the screen, and get xth word of SLL1.
- For example; if the randomly generated number is 4, the animal “BEAR” is selected from the animal list.
- Store this word in a Single Link List (SLL4).
- In addition to SLL4, create an empty Single Linked List, named SLL5, for the game board
![Ekran görüntüsü 2022-08-03 170811](https://user-images.githubusercontent.com/109742155/182629045-6b32c1ad-87a3-4d78-8830-a17b74734160.png)
## Game Playing
- The game board (SLL5) must be seen on the screen, permanently.
- The program should randomly select a letter from SLL2. After that, the letter should be deleted from SLL2.
- If the selected letter does not exist in SLL4, the player does not earn anything in this step.
- If the user suggests a letter that exists in SLL4, the computer writes it in all its correct positions in SLL5.
### For example;
- If the selected letter is “E”, then the SLL5 should be as follows:
![Ekran görüntüsü 2022-08-03 171029](https://user-images.githubusercontent.com/109742155/182629556-346c7918-06a5-46cd-b3fc-76b6f9e965f7.png)
- The program must display all steps until the game is over. In other words, the program must repeatedly print SLL5, the current step,
the score, and the remaining letters (SLL2) on the screen.
## Scoring
- If the guess is correct, then a prize according to the wheel segment is paid. The amount in the wheel segment is multiplied by the number of times that the letter appears in the word.
## End of the Game
- The game is over when the player completes the whole word correctly.
## High Score Table
- If the player earns a score within the top-10 results, he/she will be displayed in the High-Score table.
- Add into SLL3. If the same score exists in the table, the new score should be inserted to the next of them. Delete the last record.
- The new score table should be written to the file (“D:\\HighScoreTable.txt”).
## Additionaly
- You create a animal txt like highscore.
## Sample HighScore and Animal Txt
![Ekran görüntüsü 2022-08-03 171234](https://user-images.githubusercontent.com/109742155/182630387-49812b1c-2267-4323-a211-bd353b32e3be.png)
## Sample Output
![Ekran görüntüsü 2022-08-03 171215](https://user-images.githubusercontent.com/109742155/182630448-677a953e-7476-4c7a-9584-deb7c20691ce.png)



