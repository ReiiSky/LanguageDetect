package LanguageDetect.DetectLangFacade.WordList;

/**
 * Word Object that keeps each fullword's or trigram word's
 * string and count.
 *
 * Created by MuratCan on 3.1.2016.
 */
public class Word implements Comparable<Word>{
    private String string;
    private int count;

    /**
     * Default Constructor
     * Initial count is 1.
     *
     * @param string
     */
    public Word(String string) {
        this.string = string;
        this.count = 1;
    }

    /**
     * Constructor.
     * Sets the given string and the count.
     *
     * @param string
     * @param count
     */
    public Word(String string, int count) {
        this.string = string;
        this.count = count;
    }
    //String getter, setter.
    public String getString() { return string; }
    public void setString(String string) { this.string = string; }
    //Count getter, setter.
    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    /**
     * Increments count by one.
     */
    public void incCount(){ this.count += 1; }

    /**
     * Adds the given count to its count.
     *
     * @param count
     */
    public void addCount(int count){ this.count += count; }

    /**
     * ArrayList's contains() method uses equals()
     * method of the object to evaluate if two objects
     * are the same.
     *
     * So we compare Word's string field in equals()
     * method so that we can evaluate if the WordList
     * contains the same Word.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;

        Word word = (Word) o;

        return getString().equals(word.getString());
    }

    /**
     * ArrayList's sort() method uses compareTo() method
     * of the object to evaluate the order of objects in
     * the list.
     *
     * So we compare Word's count field in compareTo()
     * method so that we can sort the list according to
     * its objects count field.
     */
    @Override
    public int compareTo(Word o) {
        return this.getCount() == o.getCount() ? 0 : (this.getCount()<o.getCount() ? -1 : 1);
    }
}
