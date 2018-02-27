package conrollers;
import java.awt.TextArea;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.util.Pair;



public class Controller {
  SecureRandom rand = new SecureRandom((new Date()).toString().getBytes());
  String word = "word";
  //Генерация p и q
  BigInteger p = BigInteger.probablePrime(1024, rand);
  BigInteger q = BigInteger.probablePrime(1024, rand);
  //Вычисляем модуль n
  BigInteger n = p.multiply(q);
  //Вычисляем значение функции Эйлера
  BigInteger f = (p.subtract(new BigInteger("1"))).multiply(q.subtract(new BigInteger("1")));
  //Выбираем открытую экспоненту e
  BigInteger e = new BigInteger("65537");
  //Вычичсляем закрытую экспоненту d
  BigInteger d = e.gcd(f);
  //Открытый ключ
  Pair publicKey = new Pair(n,e);
  //Закрытый ключ
  Pair privateKey = new Pair(n,d);

  @FXML
  TextArea InputTextArea;
  @FXML
  TextArea OutputTextArea;

  public void crypt(ActionEvent actionEvent) {
    SecureRandom rand = new SecureRandom((new Date()).toString().getBytes());
    String word = "word";
    //Генерация p и q
    BigInteger p = BigInteger.probablePrime(1024, rand);
    BigInteger q = BigInteger.probablePrime(1024, rand);
    //Вычисляем модуль n
    BigInteger n = p.multiply(q);
    //Вычисляем значение функции Эйлера
    BigInteger f = (p.subtract(new BigInteger("1"))).multiply(q.subtract(new BigInteger("1")));
    //Выбираем открытую экспоненту e
    BigInteger e = new BigInteger("65537");
    //Вычичсляем закрытую экспоненту d
    BigInteger d = e.modInverse(n);
    //Открытый ключ
    Pair publicKey = new Pair(n,e);
    //Закрытый ключ
    Pair privateKey = new Pair(n,d);
    System.out.println("n= " + publicKey.getKey());
    System.out.println("e= " + publicKey.getValue());
    System.out.println("d= " + privateKey.getValue());

    //Шифрование
    List<BigInteger> code = new List<BigInteger>() {
      @Override
      public int size() {
        return 0;
      }

      @Override
      public boolean isEmpty() {
        return false;
      }

      @Override
      public boolean contains(Object o) {
        return false;
      }

      @Override
      public Iterator<BigInteger> iterator() {
        return null;
      }

      @Override
      public Object[] toArray() {
        return new Object[0];
      }

      @Override
      public <T> T[] toArray(T[] a) {
        return null;
      }

      @Override
      public boolean add(BigInteger bigInteger) {
        return false;
      }

      @Override
      public boolean remove(Object o) {
        return false;
      }

      @Override
      public boolean containsAll(Collection<?> c) {
        return false;
      }

      @Override
      public boolean addAll(Collection<? extends BigInteger> c) {
        return false;
      }

      @Override
      public boolean addAll(int index, Collection<? extends BigInteger> c) {
        return false;
      }

      @Override
      public boolean removeAll(Collection<?> c) {
        return false;
      }

      @Override
      public boolean retainAll(Collection<?> c) {
        return false;
      }

      @Override
      public void clear() {

      }

      @Override
      public BigInteger get(int index) {
        return null;
      }

      @Override
      public BigInteger set(int index, BigInteger element) {
        return null;
      }

      @Override
      public void add(int index, BigInteger element) {

      }

      @Override
      public BigInteger remove(int index) {
        return null;
      }

      @Override
      public int indexOf(Object o) {
        return 0;
      }

      @Override
      public int lastIndexOf(Object o) {
        return 0;
      }

      @Override
      public ListIterator<BigInteger> listIterator() {
        return null;
      }

      @Override
      public ListIterator<BigInteger> listIterator(int index) {
        return null;
      }

      @Override
      public List<BigInteger> subList(int fromIndex, int toIndex) {
        return null;
      }
    };

  }
}
