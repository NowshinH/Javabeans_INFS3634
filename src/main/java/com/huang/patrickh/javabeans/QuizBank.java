package com.huang.patrickh.javabeans;


public class QuizBank {

    /* QuizBank contains all of the MCQ questions and answers within arrays and the methods to return these questions and answers in the multiple choice activity in the game.*/
    //Source: https://github.com/skooltch84/MultipleChoiceQuiz
    //Source: https://github.com/skooltch84/TrueOrFalse1

    //----------------------------------------------------------------------MULTIPLE CHOICE QUIZ-------------------------------------------------------------//
    //Returns the question number based on the module selected
    public static int getMCQuestionNum(String moduleType) {
        int aMCQNum = 0;
        if(moduleType.equals("Abstraction")){
            aMCQNum = aTFQuestions.length;
        }else if(moduleType.equals("Polymorphism")){
            aMCQNum = pTFQuestions.length;
        }else if(moduleType.equals("Inheritance")){
            aMCQNum = iTFQuestions.length;
        }else if(moduleType.equals("Encapsulation")){
            aMCQNum = eTFQuestions.length;
        }
        return aMCQNum;
    }

    //Returns the question based on the module selected
    public String getMCQuestion(String moduleType, int a) {
        String question = null;

        if(moduleType.equals("Abstraction")){
            question = aMCQuestions[a];
        }else if(moduleType.equals("Polymorphism")){
            question = pMCQuestions[a];
        }else if(moduleType.equals("Inheritance")){
            question = iMCQuestions[a];
        }else if(moduleType.equals("Encapsulation")){
            question = eMCQuestions[a];
        }

        return question;
    }

    //Returns multiple choice 1 based on the module selected
    public String getMCOption1(String moduleType, int a) {
        String option0 = null;
        if(moduleType.equals("Abstraction")){
            option0 = aMCOptions[a][0];
        }else if(moduleType.equals("Polymorphism")){
            option0 = pMCOptions[a][0];
        }else if(moduleType.equals("Inheritance")){
            option0 = iMCOptions[a][0];
        }else if(moduleType.equals("Encapsulation")){
            option0 = eMCOptions[a][0];
        }
        return option0;
    }

    //Returns multiple choice 2 based on the module selected
    public String getMCOption2(String moduleType, int a) {
        String option1 = null;
        if(moduleType.equals("Abstraction")){
            option1 = aMCOptions[a][1];
        }else if(moduleType.equals("Polymorphism")){
            option1 = pMCOptions[a][1];
        }else if(moduleType.equals("Inheritance")){
            option1 = iMCOptions[a][1];
        }else if(moduleType.equals("Encapsulation")){
            option1 = eMCOptions[a][1];
        }
        return option1;
    }

    //Returns multiple choice 3 based on the module selected
    public String getMCOption3(String moduleType ,int a) {
        String option2 = null;
        if(moduleType.equals("Abstraction")){
            option2 = aMCOptions[a][2];
        }else if(moduleType.equals("Polymorphism")){
            option2 = pMCOptions[a][2];
        }else if(moduleType.equals("Inheritance")){
            option2 = iMCOptions[a][2];
        }else if(moduleType.equals("Encapsulation")){
            option2 = eMCOptions[a][2];
        }
        return option2;
    }

    //Returns multiple choice 4 based on the module selected
    public String getMCOption4(String moduleType, int a){
        String option3 = null;
        if(moduleType.equals("Abstraction")){
            option3 = aMCOptions[a][3];
        }else if(moduleType.equals("Polymorphism")){
            option3 = pMCOptions[a][3];
        }else if(moduleType.equals("Inheritance")){
            option3 = iMCOptions[a][3];
        }else if(moduleType.equals("Encapsulation")){
            option3 = eMCOptions[a][3];
        }
        return option3;
    }

    //Returns multiple choice answer based on the module selected
    public String getMCAnswer(String moduleType, int a) {
        String answer = null;
        if(moduleType.equals("Abstraction")){
            answer = aMCAnswers[a];
        }else if(moduleType.equals("Polymorphism")){
            answer = pMCAnswers[a];
        }else if(moduleType.equals("Inheritance")){
            answer = iMCAnswers[a];
        }else if(moduleType.equals("Encapsulation")){
            answer = eMCAnswers[a];
        }
        return answer;
    }

    //Returns multiple choice explanation of incorrect answer, based on the module selected
    public String getMCExp(String moduleType, int a) {
        String exp = null;
        if(moduleType.equals("Abstraction")){
            exp = aMCExp[a];
        }else if(moduleType.equals("Polymorphism")){
            exp = pMCExp[a];
        }else if(moduleType.equals("Inheritance")){
            exp = iMCExp[a];
        }else if(moduleType.equals("Encapsulation")){
            exp = eMCExp[a];
        }
        return exp;

    }

    //----------------------------------------------------------------------TRUE/FALSE QUIZ-------------------------------------------------------------//

    //Returns the true/false statement based on the module selected
    public static String getTFQuestion(String moduleType, int qNum) {
        String q = null;
        if(moduleType.equals("Abstraction")){
            q = aTFQuestions[qNum];
        }else if(moduleType.equals("Polymorphism")){
            q = pTFQuestions[qNum];
        }else if(moduleType.equals("Inheritance")){
            q = iTFQuestions[qNum];
        }else if(moduleType.equals("Encapsulation")){
            q = eTFQuestions[qNum];
        }
        return q;
    }

    //Returns the true/false answer based on the module selected
    public static boolean getTFAnswer(String moduleType, int qNum){
        boolean answer = false;
        if(moduleType.equals("Abstraction")){
            answer = aTFAnswers[qNum];
        }else if(moduleType.equals("Polymorphism")){
            answer = pTFAnswers[qNum];
        }else if(moduleType.equals("Inheritance")){
            answer = iTFAnswers[qNum];
        }else if(moduleType.equals("Encapsulation")){
            answer = eTFAnswers[qNum];
        }
        return answer;
    }

    //Returns the true/false statement number (order) based on the module selected
    public static int getTFQuestionNum(String moduleType){
        int TFNum = 0;
        if(moduleType.equals("Abstraction")){
            TFNum = aTFQuestions.length;
        }else if(moduleType.equals("Polymorphism")){
            TFNum = pTFQuestions.length;
        }else if(moduleType.equals("Inheritance")){
            TFNum = iTFQuestions.length;
        }else if(moduleType.equals("Encapsulation")){
            TFNum = eTFQuestions.length;
        }
        return TFNum;
    }


    //--------------------------------------------------Multiple Choice--------------------------------------------------//
    //Source: https://github.com/skooltch84/MultipleChoiceQuiz

    //ABSTRACTION MULTIPLE CHOICE QUIZ QUESTIONS AND ANSWERS

    //Multiple Choice Questions for the Abstraction Module (stored in an array)
    private static String aMCQuestions [] = {
            "1. Abstraction is the process of hiding the _______ details from the user.",
            "2. What keyword must be included when declaring an abstract class?",
            "3. An abstract method is a method without a _____, i.e. no implementation.",
            "4. If a class has an abstract method, it should be declared a  _____ class.",
            "5. Instead of curly braces, an abstract method will have a __, at the end."

    };

    //Multiple Choice Options for Abstraction Module (stored in a 2D array)
    private String aMCOptions [][] = {
            {"Object", "Implementation", "Process", "Functionality"},
            {"new", "this", "super", "abstract"},
            {"Signature", "Name", "Parameter", "Body"},
            {"Concrete", "Abstract", "Super", "Sub"},
            {"Colon", "String", "Semi-colon", "Comma"}
    };

    //Multiple Choice Answers for Abstraction Module (stored in an array)
    private String aMCAnswers  [] = {"Implementation", "abstract", "Body", "Abstract", "Semi-colon"};


    //Explanations for why the question is incorrect (stored in an array)
    private String aMCExp [] = {
            "Incorrect. Correct answer is 'Implementation'. Abstraction is the process of hiding the implementation details from the user, such that only functionality will provided to the user.",
            "Incorrect. Correct answer is 'Abstract'. An abstract class must be declared using the abstract keyword.",
            "Incorrect. Correct answer is 'Body'. An abstract method is a method without a body, that is it has no implementation. ",
            "Incorrect. Correct answer is 'Abstract'. Any class with at least one abstract method must be declared an abstract class.",
            "Incorrect. Correct answer is 'Semi-colon'. Abstract methods do not have a body and therefore must end with a semi-colon instead of curly braces."

    };

    //Source: https://beginnersbook.com/2014/01/abstract-method-with-examples-in-java/
    //Source: https://www.tutorialspoint.com/java/java_abstraction.htm


    //POLYMORPHISM MULTIPLE CHOICE QUIZ QUESTIONS AND ANSWERS

    //Multiple Choice Questions for the Polymorphism Module (stored in an array)
    private String pMCQuestions [] = {
            "1. The ability for the same code to be used with different types of objects and behave differently with each object is known as what?",
            "2. Polymorphism allows methods to be used generically for a wide range of object arguments. This is known as ___ programming.",
            "3. Polymorphism allows you to define one interface and have ____ implementations. ",
            "4. In the previous Animal class example, when the Horse object is passed into the sound() method, the particular implementation of the object that is invoked is determine dynamically during which stage?",
            "5. A common example of polymorphism is when a parent class is used to refer to a ____ class object."

    };

    //Multiple Choice Options for Polymorphism Module (stored in a 2D array)
    private String pMCOptions [][] = {
            {"Abstraction", "Polymorphism", "Inheritance", "Encapsulation"},
            {"Dynamic", "Static", "Generic", "Object-Oriented"},
            {"No", "Multiple", "Similar", "Different"},
            {"Compilation", "Runtime", "Execution", "Debugging"},
            {"Abstract", "Concrete", "Child", "Public"}
    };


    //Multiple Choice Answers for Polymorphism Module (stored in an array)
    private String pMCAnswers  [] = {"Polymorphism", "Generic", "Multiple", "Runtime", "Child"};


    //Explanations for why the question is incorrect (stored in an array)
    private String pMCExp [] = {
            "Incorrect. Correct answer is 'Polymorphism'. This is known as Polymorphism.",
            "Incorrect. Correct answer is 'Generic'. Allowing methods to be used generically for a wide range of object arguments is known as generic programming.",
            "Incorrect. Correct answer is 'Multiple'. Polymorphism allows you to define one interface and have multiple implementations. ",
            "Incorrect. Correct answer is 'Runtime'. The particular implementation of the object that is invoked is determined dynamically during runtime.",
            "Incorrect. Correct answer is 'Child'. A common example of polymorphism is when a parent class is used to refer to a child class object."
    };

    //Source: https://www.tutorialspoint.com/java/java_polymorphism.htm
    //Source: https://beginnersbook.com/2013/03/polymorphism-in-java/
    //Source: https://www.guru99.com/java-inheritance-polymorphism.html
    //Source: https://www.javatpoint.com/runtime-polymorphism-in-java

    //INHERITANCE MULTIPLE CHOICE QUIZ QUESTIONS AND ANSWERS

    //Multiple Choice Questions for the Inheritance Module (stored in an array)
    private String iMCQuestions [] = {
            "1. What term is used to define a class that is derived from another class?",
            "2. To inherit a class, we use the __ keyword.",
            "3. Which of these are not inherited by a subclass from a superclass?",
            "4. Which of these is a benefit of inheritance?",
            "5. The keyword, __ can be used to invoke a superclass constructor or a superclass method."

    };


    //Multiple Choice Options for Inheritance Module (stored in a 2D array)
    private String iMCOptions [][] = {
            {"Superclass", "Abstract class", "Concrete class", "Subclass"},
            {"new", "super", "extends", "this"},
            {"Fields", "Methods", "Constructors", "Nested Classes"},
            {"Method overloading", "Encapsulation", "Method overriding", "Abstraction"},
            {"new", "super", "extends", "this"}
    };


    //Multiple Choice Answers for Inheritance Module (stored in an array)
    private String iMCAnswers  [] = {"Subclass", "extends", "Constructors", "Method overriding", "super"};


    //Explanations for why the question is incorrect (stored in an array)
    private String iMCExp [] = {
            "Incorrect. Correct answer is 'Subclass'. A subclass is a class that is derived from another class.",
            "Incorrect. Correct answer is 'extends'. To inherit a class, we use the extends keyword.",
            "Incorrect. Correct answer is 'Constructors'. Constructors are not inherited by subclasses, but the constructor of the superclass can be invoked from the subclass.",
            "Incorrect. Correct answer is 'Method overriding'. The two key benefits of inheritance are method overriding and code reusability.",
            "Incorrect. Correct answer is 'super'. The keyword, super can be used to invoke a superclass constructor or a superclass method."
    };

    //Source: https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html
    //Source: https://www.geeksforgeeks.org/inheritance-in-java/
    //Source: tutorials.jenkov.com/java/constructors.html
    //Source: https://beginnersbook.com/2013/03/inheritance-in-java/


    //ENCAPSULATION MULTIPLE CHOICE QUIZ QUESTIONS AND ANSWERS

    //Multiple Choice Questions for the Encapsulation Module (stored in an array)
    private String eMCQuestions [] = {
            "1. What term is used to describe the OOP principle by which an object’s data fields and methods are bound together?",
            "2. Getter and setter methods are used to read and modify ___ data fields.",
            "3. Which of these is not a benefit of encapsulation?",
            "4. Which modifier is accessible by any class in the same package or its subclasses?",
            "5. Encapsulation ensures that all __ details are hidden from the user. "

    };

    //Multiple Choice Options for Encapsulation Module (stored in a 2D array)
    private String eMCOptions [][] = {
            {"Abstraction", "Polymorphism", "Inheritance", "Encapsulation"},
            {"public", "private", "protected", "default"},
            {"Protected data", "Easy to maintain", "Code reusability", "Data hiding"},
            {"public", "private", "protected", "default"},
            {"Class", "Private", "Public", "Implementation"}
    };


    //Multiple Choice Answers for Encapsulation Module (stored in an array)
    private String eMCAnswers  [] = {"Encapsulation", "private", "Code reusability", "protected", "Implementation"};


    //Explanations for why the question is incorrect (stored in an array)
    private String eMCExp [] = {
            "Incorrect. Correct answer is 'Encapsulation'. Encapsulation is an OOP principle which binds together an object’s properties (fields) and behaviours (methods).",
            "Incorrect. Correct answer is 'private'. Getter and setter methods are used to read and modify private data fields.",
            "Incorrect. Correct answer is 'Code reusability'. This is a benefit of Inheritance not Encapsulation. Encapsulation allows for data hiding and ensures the data is protected, making the code easier to maintain.",
            "Incorrect. Correct answer is 'protected'. The protected modifier is accessible by any class in the same package or its subclasses.",
            "Incorrect. Correct answer is 'Implementation'. Encapsulation ensures that all implementation details are hidden from the user. "
    };

    //Source: https://beginnersbook.com/2013/05/encapsulation-in-java/
    //Source: https://beginnersbook.com/2013/03/oops-in-java-encapsulation-inheritance-polymorphism-abstraction/
    //Source: http://www.cems.uwe.ac.uk/~jsa/UMLJavaShortCourse09/CGOutput/Unit6/unit6(0809)/page_06.htm
    //Source: https://www.geeksforgeeks.org/encapsulation-in-java/

    //--------------------------------------------------True or False--------------------------------------------------//
    //Source: https://github.com/skooltch84/TrueOrFalse1

    //ABSTRACTION TRUE/FALSE QUIZ QUESTIONS AND ANSWERS

    //True/False Statements for the Abstraction Module (stored in an array)
    private static String[] aTFQuestions = new String [] {
            "1. An abstract method contains method signature without a body.",
            "2. An abstract class must contain abstract methods.",
            "3. If a regular class extends an abstract class, then the class must have to implement all of the abstract methods of the abstract parent class or it has to be declared abstract as well.",
            "4. If you inherit an abstract class, you do not have to provide implementations to all the abstract methods in it.",
            "5. An abstract class can be instantiated.",
    };

    //Answers to True/False Statements (stored in an array)
    private static boolean[] aTFAnswers = new boolean[]{
            true, false, true, false, false
    };

    //Source: https://beginnersbook.com/2014/01/abstract-method-with-examples-in-java/
    //Source: https://www.tutorialspoint.com/java/java_abstraction.htm


    //POLYMORPHISM TRUE/FALSE QUIZ QUESTIONS AND ANSWERS

    //True/False Statements for the Polymorphism Module (stored in an array)
    private static String[] pTFQuestions = new String [] {
            "1. As an instance of a subclass is always an instance of its superclass, we can handle subclass objects as if they were superclass objects.",
            "2. A common use of polymorphism is when a child class is object is used to refer to a parent class.",
            "3. Polymorphism is a key concept within object-oriented programming.",
            "4. As a superclass guarantees certain operations in its subclasses, we can invoke those operations without caring which subclass the actual object is an instance of.",
            "5. Consider the analogy of fruit. An apple is fruit, so you can always safely assign an instance of Fruit to a variable for Apple.",
    };

    //Answers to True/False Statements (stored in an array)
    private static boolean[] pTFAnswers = new boolean[]{
            true, false, true, true, false

    };

    //Source: https://www.tutorialspoint.com/java/java_polymorphism.htm
    //Source: https://beginnersbook.com/2013/03/polymorphism-in-java/
    //Source: https://www.guru99.com/java-inheritance-polymorphism.html
    //Source: https://www.javatpoint.com/runtime-polymorphism-in-java

    //INHERITANCE TRUE/FALSE QUIZ QUESTIONS AND ANSWERS

    //True/False Statements for the Inheritance Module (stored in an array)
    private static String[] iTFQuestions = new String [] {
            "1. A subclass can have more than one superclass however a superclass can only have one subclass.",
            "2. Method overriding allows you have the two methods with the same name but different method signature in a class.",
            "3. Except for the Object class, every class has only one direct superclass.",
            "4. A subclass does not inherit the private fields, methods or nested classes of its parent class.",
            "5. If the superclass has public/protected getter and setter methods for accessing its private fields, these can be use used by the subclass.",
    };

    //Answers to True/False Statements (stored in an array)
    private static boolean[] iTFAnswers = new boolean[]{
            false, false, true, true, true
    };

    //Source: https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html
    //Source: https://www.geeksforgeeks.org/inheritance-in-java/
    //Source: tutorials.jenkov.com/java/constructors.html
    //Source: https://beginnersbook.com/2013/03/inheritance-in-java/


    //ENCAPSULATION TRUE/FALSE QUIZ QUESTIONS AND ANSWERS

    //True/False Statements for the Encapsulation Module (stored in an array)
    private static String[] eTFQuestions = new String [] {
            "1. To prevent direct modification of data fields, data should be declared public.",
            "2. If you create a class, this is known as encapsulation.",
            "3. If no visibility modifier is used, the default modifier is used which is accessible within its own class or its subclass.",
            "4. Encapsulation ensures that the data is protected and makes the code, easier to maintain.",
            "5. Encapsulation is the principle by which the details of implementation are encapsulated and hidden from the user.",
    };

    //Answers to True/False Statements (stored in an array)
    private static boolean[] eTFAnswers = new boolean[]{
            false, true, false, true, true
    };

    //Source: https://beginnersbook.com/2013/05/encapsulation-in-java/
    //Source: https://beginnersbook.com/2013/03/oops-in-java-encapsulation-inheritance-polymorphism-abstraction/
    //Source: http://www.cems.uwe.ac.uk/~jsa/UMLJavaShortCourse09/CGOutput/Unit6/unit6(0809)/page_06.htm
    //Source: https://www.geeksforgeeks.org/encapsulation-in-java/


//--------------------------------------------------------------------------------


}