package life.qbic.senet;

import java.util.Random;

/**
 * TODO!
 * <b>short description</b>
 *
 * <p>detailed description</p>
 *
 * @since <version tag>
 */
public class Knucklebones {

  private static final Random random = new Random();

  public static int throwBones() {
    return random.nextInt(5) + 1;
  }

}
