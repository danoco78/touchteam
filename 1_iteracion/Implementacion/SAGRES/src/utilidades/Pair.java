package utilidades;

/**
 *
 * @author Daniel
 */
public class Pair<F,S> {
  private F o1;
  private S o2;
  public Pair(F o1, S o2) { this.o1 = o1; this.o2 = o2; }

  public F getFirst() { return o1; }
  public S getSecond() { return o2; }

  void setFirst(F o) { o1 = o; }
  void setSecond(S o) { o2 = o; }

  @Override
  public String toString() {
    return "Pair{"+o1+", "+o2+"}";
  }

}
