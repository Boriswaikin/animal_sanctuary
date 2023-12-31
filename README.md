# Animal Sanctuary 

#### Overview:

A Java-based software for managing an animal sanctuary, adhering to MVC architecture

#### Feature:

Below is the feature of the program:
1. Register the monkey by inputting the monkey's Name, Species, Sex, Size, Weight, Age and its favourite food. 
2. The new monkey being registered would be put in isolation
3. For the monkey living in the isloation, its name would be shown in the combobox. It allows us to select the monkey to be moved to enclosure. 
4. Can move the selected monkey to the enclosure. Once the monkey is moved to enclosure, the monkey would be taken away from the isolation and moved to be shown in the row (enclosure for specific species) according to its species.
5. Able to select the list of every enclosure by choosing the specific species.
6. Able to list out the names of the monkeys living in sanctuary in alphabetical order.

#### Layout:

<p float="left">
<img src="./images/Layout.png"  width=“300" />
</p>

#### How to run:

1.Put the jar file to the desktop.
2.Right click, choose "Open With", choose "JavaLauncher(default)".
3.If asked are you sure you want to open it, click "Open".

#### How to use the program:

When open the program, the view of the program named "Primates" will be shown

1.The first row is the monkey's input. Below is the regulation of inputting the attribute
a.Name: Please input the valid name of monkey. Empty name or the name including non alphabets are not allowed
b.Select species of the monkey
c.Select sex of the monkey
d.Size: Please input a valid numeric value. The value has to be greater than zero.
e.Weight: Please input a valid numeric value. The value has to be greater than zero.
f.Age: Please input a valid numeric value. The value has to be greater than zero.
g.Select favourite food of the monkey.
Below is one of the example to input all the valid attributes of the monkey:
Name: Abu 
Species: DRILL
Sex: M
Size: 12.4
Weight: 8.345
Age: 16.2342
Food: EGGS

2. The second row has two buttons and one combobox in between. The first button named "Register Monkey", it allows us to put the monkey to the isolation box once all the valid attibutes of monkey are input. After you clicked the button "Register Monkey", the monkey with picture and its name would be shown in the isolation box. The combobox in between the buttons allow us to select the monkey that is in the isolation. Once the monkey is selected, then we can click the button next to it, which is named "Move to Enclosure", it allows us to move the monkey from the isolation to the speceifc row of the enclosure for species (the monkey will be automatically moved to correct row according to the monkey's species)
3. The third row has one combobox and two buttons. The combox box has the options of eight species. We can select the species and click the button next to it, which named "Specific Enclosure List" to get the list of the monkeys in the specific enclosures that we chose. The list of the monkeys contain the monkey's name, sex and its favourite food. If multiple monkeys are in the enclosure we chose, the monkeys would be sorted in alphabetical order of their name. The last button in the third row is named "Sanctuary List", it allows us to get the list of the names of the monkeys that in the sanctuary. The name list are sorted in alphabetical order.

#### Assumption:
1. The monkey is unhealthy at the time when he/she is registered.
2. Same name of monkey in the sanctuary is not allowed.
3. The monkeys living in the enclosure would live forever.

#### Limitation:
1. The is no memoization on the monkeys in the sanctuary. 
It implies if three monkeys are registered and two are moved from isolation to enclosure. 
When the jar file is closed and is reopened, all monkeys record would be disappeared and we need to re-register the monkeys again.
2, In the isolation view and enclosure view, only the monkey's picture and monkey's name is shown. No other attributes of the monkey are provided. 

#### Citation:
[1] Java Swing How to - Add custom Java objects to JComboBox
http://www.java2s.com/Tutorials/Java/Swing_How_to/JComboBox/Add_custom_Java_objects_to_JComboBox.htm (accessed 9 Dec 2022)

[2] How to Use BoxLayout
https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html (accessed 9 Dec 2022)

[3] How to add multiple panels in JFrame in Java
https://www.codespeedy.com/how-to-add-multiple-panels-in-jframe-in-java/ (accessed 9 Dec 2022)

[4] How to resize JLabel ImageIcon?
https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon (accessed 9 Dec 2022)
