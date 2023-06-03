package com.example.sampleproject;

public class CardPicking {
    class CardPicker {
        public static String[] getNextCard(int[] cardlist, int index) throws IllegalArgumentException {
            int number = cardlist[index];
            if (index > 35 || index < 1) {
                throw new IllegalArgumentException("kill your self");
            }
            String suit = null;
            String nominal = null;
            if (number <= 9) {
                suit = "Hearts";
                switch (number) {
                    case 9:
                        nominal = "Ace";
                        break;
                    case 6:
                        nominal = "Jack";
                        break;
                    case 7:
                        nominal = "Queen";
                        break;
                    case 8:
                        nominal = "King";
                        break;
                    default:
                        nominal = Integer.toString(number);
                }

            }
            if (number <= 18 && number > 9) {
                suit = "Diamonds";
                switch (number - 9) {
                    case 9:
                        nominal = "Ace";
                        break;
                    case 6:
                        nominal = "Jack";
                        break;
                    case 7:
                        nominal = "Queen";
                        break;
                    case 8:
                        nominal = "King";
                        break;
                    default:
                        nominal = Integer.toString(number);
                }

            }
            if (number <= 27 && number > 18) {
                suit = "Spades";
                switch (number - 18) {
                    case 9:
                        nominal = "Ace";
                        break;
                    case 6:
                        nominal = "Jack";
                        break;
                    case 7:
                        nominal = "Queen";
                        break;
                    case 8:
                        nominal = "King";
                        break;
                    default:
                        nominal = Integer.toString(number);
                }

            }
            if (number > 27) {
                suit = "Clubs";
                switch (number - 27) {
                    case 9:
                        nominal = "Ace";
                        break;
                    case 6:
                        nominal = "Jack";
                        break;
                    case 7:
                        nominal = "Queen";
                        break;
                    case 8:
                        nominal = "King";
                        break;
                    default:
                        nominal = Integer.toString(number);
                }

            }
            String[] result = new String[1];
            result[0] = nominal;
            result[1] = suit;

            return result;
        }

    }
}
