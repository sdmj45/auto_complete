# Auto Complete

This is an auto complete implementation test, the behaviors of this test
  - There are 4 suggestions maximum
  - Letters types are not case sensitive 
  - Results are in alphabetical order

### Version
1.0.0.0

### Tech

* [Scala] - Language with witch application is developed
* [Scala Test] - Unit Test for Scala
* [Maven] - build automation tool
* [Ternary Search Tree] - algorithm used

### Installation

Application requires [Java](https://www.java.com) v8+ and [Maven](https://maven.apache.org/) 3+ to run.

Use maven to install the application:

```sh
$ mvn clean install
```
After the jar is built, you can run the application with the command as below:
```sh
$ java -cp target\auto_complete-1.0.0.0.jar com.mj.auto_complete.Demo
```

### How to Work

There are 5 operations you can choose 
1. test auto complete only with the elements given ("Pandora", "Pinterest", "Paypal"...)
2. insert word(if multiple, separated by comma)
3. check word exists
4. auto complete suggestion
5. clear the memory

You can choose the operation by typing the corresponding number

1. test auto complexation only with the elements given ("Pandora", "Pinterest", "Paypal"...)
* Firstly, It will clear all the registration in the memory, secondly, it will insert the elements as below automatically. And then you can type the prefix directly to get the suggestions
* ("Pandora", "Pinterest", "Paypal", "Pg&e", "Project free tv Priceline", "Press democrat", "Progressive", "Project runway", "Proactive", "Programming", "Progeria", "Progesterone", "Progenex", "Procurable", "Processor", "Proud", "Print", "Prank", "Bowl", "Owl", "River", "Phone", "Kayak", "Stamps", "Reprobe")

2. insert word(if multiple, separated by comma)
* You can insert the words as you want, if you want to insert multiple words at the same time, you have to separate them by comma

3. check word exists
* If the word you typed exists in memory, it will print "word exists", else it will print "word does not exist"

4. auto complete suggestion
* You can type the prefix as you want, if there is no suggestion, it will print "no result found", else it will print the 4 first suggestions exist in memory

5. clear the memory
* it will clear all of the node tree