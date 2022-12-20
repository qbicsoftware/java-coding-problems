package life.qbic.day8;

/**
 * <b>short description</b>
 *
 * <p>detailed description</p>
 *
 * @since <version tag>
 */
public enum Inputs {

  EIGHT("""
  30373
  25512
  65332
  33549
  35390""");

  private final String content;

  Inputs(String content) {
    this.content = content;
  }

  public String content() {
    return content;
  }
}
