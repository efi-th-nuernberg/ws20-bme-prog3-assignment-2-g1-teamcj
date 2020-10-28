class TextFormatter {

  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";

private static int textLengthPerLine;
private static int format; //1 für links, 2 für rechts, 3 mittig

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30, 3); 
    formatter.print(text); 
  }

  // Konstruktor
  public TextFormatter(int maxLineLength, int format) {
    textLengthPerLine = maxLineLength;
    this.format = format;
  }

  // Ausgabe
  public void print(String aText){
    String[] textArray = aText.split(" ");
    String help = "";
    for (int i=0; i < textArray.length; i++){
      int sizeWord = textArray[i].length();
      if ((help.length() + sizeWord) < textLengthPerLine){
        if (help.equals("")){ //beim 1.Mal kein Leerzeichen einfügen    
         help += textArray[i]; 
        } else {
         help += " " + textArray[i];
        }
      } else {
        printText(help);
        if(sizeWord > textLengthPerLine){
          help = splitString(textArray[i]);
        } else {
         help = textArray[i];
        }
      }
    }
  }

  public void printText(String aText){
   switch(format){
     case 1:
      printLeft(aText);
     break;
     case 2:
      printRight(aText);
     break;
     case 3:
      printCenter(aText);
     break;
     default:
      printLeft(aText);
     break;
   }
  }

  public void printLeft(String aText){
   System.out.println(aText);
  }

  public void printRight(String aText){
    int shift = textLengthPerLine - aText.length();
    for (int i = 0; i < shift; i++){
     aText = " " + aText;
    }
    System.out.println(aText);
  }

  public void printCenter(String aText){
    int shift = textLengthPerLine - aText.length();
    shift = shift/2;
    for (int i = 0; i < shift; i++){
     aText = " " + aText;
    }
    System.out.println(aText);
  }

  public String splitString(String text){
    String wordToSplit = text;
    String first = wordToSplit.substring(0, textLengthPerLine);
    String second = wordToSplit.substring(textLengthPerLine,wordToSplit.length());
    printText(first);
   return second;
  }
}

