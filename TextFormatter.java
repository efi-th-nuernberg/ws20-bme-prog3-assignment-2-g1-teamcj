class TextFormatter {

  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";

private int textLength;

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);
    formatter.print(text);
  }

  // Konstruktor
  public TextFormatter(int maxLineLength) {
    textLength = maxLineLength;
    
  }

  // Ausgabe
  public void print(String aText) {
    String[] textArray = aText.split(" ");

    int count = 0;
    for (int i = 0; i<textArray.length; i++){
      int sizeWord = textArray[i].length();

      if (sizeWord > textLength){
          String wordToSplit = textArray[i];
          String first = wordToSplit.substring(0, textLength);
          String second = wordToSplit.substring(textLength,wordToSplit.length());
          System.out.print(first + "\n" + second +" ");
          count = second.length()+1;
        } else if(count+sizeWord > textLength){
        System.out.print("\n");
        count = 0;
      } else {
        System.out.print(textArray[i]+" ");
        count = count + sizeWord +1;
        }
      }

    //System.out.println("Hier sollte der Text mit passendem Umbruch erscheinen.");
  }

}