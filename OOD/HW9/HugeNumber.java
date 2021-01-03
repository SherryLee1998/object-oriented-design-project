package com.company;
public class HugeNumber {
    private class Digit{
        private int digit;
        private Digit previous;
        private Digit next;

        private Digit(int digit)
        {
            setDigit(digit);
            next = null;
            previous = null;
        }

        public Digit(int digit, Digit previousNode, Digit nextNode)
        {
            setDigit(digit);
            setPrevious(previousNode);
            setNext(nextNode);
        }

        public Digit getNext(){
            return next;
        }

        public Digit getPrevious(){
            return previous;
        }

        public int getDigit() {
            return digit;
        }

        public void setDigit(int digit){
            if(digit < 0 || digit > 9){
                System.out.println("Number input out of range.");
                System.exit(0);
            }
            this.digit = digit;
        }
        public void setNext(Digit next){
            this.next = next;
        }

        public void setPrevious(Digit previous){
            this.previous = previous;
        }
    }

    private Digit head;

    public HugeNumber() {
        head = null;
    }

    public HugeNumber(Digit head) {
        this.head = head;
    }

    public HugeNumber(int number){
        this(String.valueOf(number));
    }

    // HugeNumber's constructor
    public HugeNumber(String number) {
        // check if it is null or empty.
        if(number == null ||number.isEmpty()){
            System.out.println("Number could not be empty");
            return;
        }
        // check if it is 0 or 00000...
        int index = 0;
        while(index < number.length() && number.charAt(index) == '0'){
            index++;
        }

        if(index == number.length()){
            head = new Digit(0);
            return;
        }

        //link every digit and check character
        int end = number.length() - 1;
        while(end >= index){
            char c = number.charAt(end);
            if(Character.isDigit(c)){
                addToStart(c - '0');
            }else{
                head = null;
                System.out.println("Character must be digit");
                return;
            }
            end--;
        }
    }



    // copy constructor in question 2
    // copy each digit
    public HugeNumber(HugeNumber otherHugeNumber){
        if(otherHugeNumber == null){
            System.out.println("Object could not be null");
            System.exit(0);
        }
        Digit otherCurrent = otherHugeNumber.getHead();
        Digit prev = null;
        while (otherCurrent != null) {
            Digit current = new Digit(otherCurrent.getDigit());
            current.setPrevious(prev);
            if (prev == null) {
                head = current;
            } else {
                prev.setNext(current);
            }

            otherCurrent = otherCurrent.getNext();
            prev = current;
        }
    }

    // add a digit to start
    public void addToStart(int number)
    {
        Digit newHead = new Digit(number, null, head);
        if(head != null) {
            head.setPrevious(newHead);
        }
        head = newHead;
    }

    // return the head
    public Digit getHead(){
        return head;
    }


    // return the tail
    private Digit tail() {
        if (head == null) return null;
        Digit current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }


    // add other huge number
    public HugeNumber add(HugeNumber otherHugeNumber) {
        if(otherHugeNumber == null){
            System.out.println("Object could not be null");
            return null;
        }
        Digit position1 = this.tail();
        Digit position2 = otherHugeNumber.tail();
        if(position1 == null || position2 == null){
            System.out.println("Head could not be null");
            return null;
        }

        int carry = 0;
        Digit current = null; // current digit in the result HugeNumber

        while (position1 != null || position2 != null) {
            int firstNumber = 0;
            int secondNumber = 0;

            if (position1 != null) {
                firstNumber = position1.getDigit();
                position1 = position1.getPrevious();
            }
            if (position2 != null) {
                secondNumber = position2.getDigit();
                position2 = position2.getPrevious();
            }

            int unitSum = firstNumber + secondNumber + carry;
            Digit number = new Digit(unitSum%10, null, current);
            carry = unitSum / 10;
            if (current != null) {
                current.setPrevious(number);
            }
            current = number;
        }

        HugeNumber result = new HugeNumber(current);
        if(carry > 0){
            result.addToStart(1);
        }
        return result;
    }

    //reset the head to be null
    public void reset(){
        head = null;
    }

    // if the head is null, it will return an empty string
    public String toString () {
        Digit position = head;
        String output = "";
        while (position != null) {
            output += position.getDigit();
            position = position.getNext();
        }
        return output;
    }

    public static void main(String[] args){
        HugeNumber number1 = new HugeNumber("123456789123456789");
        System.out.println(number1);
        HugeNumber number2 = new HugeNumber(number1); // copy constructor
        System.out.println(number2);
        HugeNumber number3 = new HugeNumber(99999);
        System.out.println(number3);
        System.out.printf("%s + %s = %s\n", number2, number3, number2.add(number3));

        HugeNumber number4 = new HugeNumber("9999999999");
        System.out.printf("%s + %s = %s\n", number3, number4, number3.add(number4));
        number4.reset();
        System.out.println(number4);//empty string
        number4.addToStart(2);
        number4.addToStart(3);
        number4.addToStart(4);
        System.out.println(number4);// 2
    }




}
