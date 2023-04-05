BASIC CONFIGURATION:

java version= 1.8
spring version=2.1.0.RELEASE
------------------------------------------------------------------------------------------
DEPENDENCY:
opencsv for csv writing
jaxb for xml conversion
-------------------------------------------------------------------------------------------
FOR IDE RUNNING :
 change the file path in the config.properties
 
In the small Text key paste the source file
In the outputCsvFile key paste the output csv file path in your local
In the outputxmlFile key paste the output xml file path in your local
------------------------------------------------------------------------------------------
FOR COMMAND PROMPT RUNNING :
In the out folder there is jar file
STEP 1:CHANGE THE FOLDER TO out\artifacts\TCSAssignment_jar
STEP 2: EXECUTE THE COMMAND:

### **java -jar TCSAssignment.jar "inputFilePath" "outputXmlFilePath" "outputCsvFilePath"**





EXAMPLE:
C:\Users\sathi>cd C:\Users\sathi\Downloads\TCSAssignment\TCSAssignment\out\artifacts\TCSAssignment_jar

C:\Users\sathi\Downloads\TCSAssignment\TCSAssignment\out\artifacts\TCSAssignment_jar>java -jar -Xmx2m TCSAssignment.jar "C:\Users\sathi\Downloads\TCSAssignment\TCSAssignment\src\main\resources\small.txt" "C:\Users\sathi\Downloads\TCSAssignment\TCSAssignment\src\main\resources\output.xml" "C:\Users\sathi\Downloads\TCSAssignment\TCSAssignment\src\main\resources\output.csv"
