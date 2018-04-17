package conrollers;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.util.Pair;



public class Controller {

  @FXML
  private TextArea input;
  @FXML
  private TextArea output;

  public void crypt(ActionEvent actionEvent) {
    SecureRandom rand = new SecureRandom();
    String word = "word";
    //Генерация p и q
    BigInteger p = BigInteger.probablePrime(2048, rand);
    BigInteger q = BigInteger.probablePrime(2048, rand);
    //Вычисляем модуль n
    BigInteger n = p.multiply(q);
    //Вычисляем значение функции Эйлера
    BigInteger f = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
    //Выбираем открытую экспоненту e
    BigInteger e = new BigInteger("65537");
    //Вычичсляем закрытую экспоненту d
    BigInteger d = e.modInverse(f);

    //Отладочная информация
    System.out.println("p = " + p);
    System.out.println("q = " + q);
    System.out.println("n = " + n);
    System.out.println("f = " + f);
    System.out.println("e = " + e);
    System.out.println("d = " + d);

    //Шифрование
    ArrayList<BigInteger> code = new ArrayList<BigInteger>();

    //Переменная для текста
    String text;
    text = input.getText();

    for (int i = 0; i<text.length(); i++){
      BigInteger tmp = new BigInteger(String.valueOf((int)text.charAt(i)));
      code.add(tmp);
    }

    System.out.println("коды букв");
    for (int i = 0; i<code.size(); i++){
      System.out.println(code.get(i));
    }

    System.out.println("Зашифрованные коды буквы");
    for (int i = 0; i<code.size();i++){
      code.set(i,code.get(i).modPow(e,n));
      System.out.println(code.get(i));
    }

    //Дешифровка
    String decode = "";

    System.out.println("дешифрованные коды букв");
    for (int i = 0; i<code.size();i++){
      System.out.println(Integer.parseInt(code.get(i).modPow(d,n).toString()));
    }

    for (int i = 0; i<code.size();i++){
      decode += (char)Integer.parseInt(code.get(i).modPow(d,n).toString());
    }
    output.setText(decode);
  }
}
