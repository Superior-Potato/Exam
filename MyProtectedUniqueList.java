import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyProtectedUniqueList<T extends Comparable> implements Iterable{
    private List<T> words;
    private String keyWord;

    public MyProtectedUniqueList(String keyWord) {
        this.keyWord = keyWord;
        this.words = new ArrayList<>();
    }

    public void Add(T wordToAdd) throws IllegalArgumentException{
        if(wordToAdd==null){
            throw new IllegalArgumentException();
        }
        if(this.words.contains(wordToAdd)){
            return;
        }
        this.words.add(wordToAdd);
    }

    public void Remove(T wordToRemove) throws IllegalArgumentException{
        if(wordToRemove==null){
            throw new IllegalArgumentException();
        }
        this.words.remove(wordToRemove);
    }

    public void RemoveAt(int index) throws IllegalArgumentException{
        if(index < 0 || index > this.words.size()){
            throw new IllegalArgumentException();
        }
        this.words.remove(index);
    }

    public void Clear(String keyWord) throws Exception{
        if(keyWord != this.keyWord){
            throw new IllegalAccessException();
        }
        this.words.clear();
    }

    public void Sort(String keyWord) throws Exception{
        if(keyWord != this.keyWord){
            throw new IllegalAccessException();
        }
        this.words.sort((T s1, T s2)-> {
            return s1.compareTo(s2);
        });
    }


    @Override
    public String toString() {
        return "MyProtectedUniqueList{" +
                "words=" + words +
                ", keyWord='" + keyWord + '\'' +
                '}';
    }

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    private class MyIterator implements Iterator<T>{

        private int myIndex;
        private MyProtectedUniqueList list;

        public MyIterator(MyProtectedUniqueList list) {
            this.myIndex = -1;
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            if(this.myIndex < this.list.words.size()-1)
                return true;
            return false;
        }

        @Override
        public T next() {
            return (T) this.list.words.get(++this.myIndex);
        }
    }

}
