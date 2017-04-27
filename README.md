# Auto Complete

This is an auto complete implementation test, the behavors of this test
  - There are 4 suggestions maximum
  - Letters types are not case sensitive 
  - Results are in alphabetical order

### Version
1.0.0.0

### Tech

* [Scala] - Language with witch application is developped
* [Scala Test] - Unit Test for Scala
* [Maven] - build automatation tool
* [Ternary Search Tree] - algorithm used

### Installation

Application requires [Java](https://www.java.com) v8+ and [Maven](https://maven.apache.org/) 3+ to run.

You need Maven installed globally:

```sh
$ mvn clean install
```
After the jar is built, you can use the command below to run the application
```sh
$ java -cp target\auto_complete-1.0.0.0.jar com.mj.auto_complete.Demo
```

### How to Work

There are 5 operations you can choose 
1. test auto completation only with the elements given ("Pandora", "Pinterest", "Paypal"...)
2. insert word(if multiple, separated by comma)
3. search word
4. auto complete suggestion
5. clear the memory

You can choose the operation by typing the corresponding number

1. test auto completation only with the elements given ("Pandora", "Pinterest", "Paypal"...)
* It will clear all the rigistration in the memory and insert the elements as below and you can type the prefix directly to get the suggestions
* ("Pandora", "Pinterest", "Paypal", "Pg&e", "Project free tv Priceline", "Press democrat", "Progressive", "Project runway", "Proactive", "Programming", "Progeria", "Progesterone", "Progenex", "Procurable", "Processor", "Proud", "Print", "Prank", "Bowl", "Owl", "River", "Phone", "Kayak", "Stamps", "Reprobe")

2. insert word(if multiple, separated by comma)
* You can insert the words as you want, if you want to insert multiple words at the same time, you have to seperate them by  comma

3. search word
* If the word you typed exists in memory, it will print "word exists", else it will print "word does not exist"

4. auto complete suggestion
* You can type the prefix as you want, if there is no suggestions, it will print "no result found", else it will print the 4 first suggestions exist in memory

5. clear the memory
* it will clear all of the memory


### Answers to the optional questions
* What would you change if the list of keywords was large (several millions)?

*  What would you change if the requirements were to match any portion of the
keywords (example: for string “pro”, code would possibly return “re pro be”)?
I will implement the Service with another algothim who names generalized suffix tree
