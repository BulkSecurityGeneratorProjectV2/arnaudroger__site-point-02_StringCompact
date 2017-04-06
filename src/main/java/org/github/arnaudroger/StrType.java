package org.github.arnaudroger;

public enum StrType {

    LATIN1           ("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris sed commodo mauris. ut elit nisl, interdum eget metus in, dignissim sollicitudin est. Ut ut sem dapibus, aliquam nisl in, volutpat elit. Duis facilisis, turpis vitae pellentesque maximus, tortor odio luctus nunc, sagittis faucibus erat arcu eu urna. Nulla nunc augue, malesuada scelerisque sodales ac, lacinia sit amet arcu. Suspendisse in sollicitudin augue, eu venenatis justo. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed iaculis lorem et porttitor imperdiet. Curabitur a tristique massa, eget faucibus risus. Ut eget arcu sed dui commodo elementum eu at dui. Nunc eget libero posuere, laoreet eros non, auctor neque. Curabitur nisl quam, consequat quis mollis at, interdum eu mauris. Praesent sollicitudin vitae massa quis aliquet.", 'U'),
    UTF16_LATIN1_CHAR("¥orem ipsum dolor sit amet, consectetur adipiscing elit. Mauris sed commodo mauris. ut elit nisl, interdum eget metus in, dignissim sollicitudin est. Ut ut sem dapibus, aliquam nisl in, volutpat elit. Duis facilisis, turpis vitae pellentesque maximus, tortor odio luctus nunc, sagittis faucibus erat arcu eu urna. Nulla nunc augue, malesuada scelerisque sodales ac, lacinia sit amet arcu. Suspendisse in sollicitudin augue, eu venenatis justo. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed iaculis lorem et porttitor imperdiet. Curabitur a tristique massa, eget faucibus risus. Ut eget arcu sed dui commodo elementum eu at dui. Nunc eget libero posuere, laoreet eros non, auctor neque. Curabitur nisl quam, consequat quis mollis at, interdum eu mauris. Praesent sollicitudin vitae massa quis aliquet.", 'U'),
    UTF16_UTF16_CHAR ("¥orem ipsum dolor sit amet, consectetur adipiscing elit. Mauris sed commodo mauris. ut elit nisl, interdum eget metus in, dignissim sollicitudin est. шt ut sem dapibus, aliquam nisl in, volutpat elit. Duis facilisis, turpis vitae pellentesque maximus, tortor odio luctus nunc, sagittis faucibus erat arcu eu urna. Nulla nunc augue, malesuada scelerisque sodales ac, lacinia sit amet arcu. Suspendisse in sollicitudin augue, eu venenatis justo. Interdum et malesuada fames ac ante ipsum primis in faucibus. Sed iaculis lorem et porttitor imperdiet. Curabitur a tristique massa, eget faucibus risus. Ut eget arcu sed dui commodo elementum eu at dui. Nunc eget libero posuere, laoreet eros non, auctor neque. Curabitur nisl quam, consequat quis mollis at, interdum eu mauris. Praesent sollicitudin vitae massa quis aliquet.", 'ш');



    private final String value;
    private final char lookup;

    StrType(String value, char lookup) {
        this.value = value;
        this.lookup = lookup;
    }

    public String value() {
        return new String(value);
    }

    public char lookup() {
        return lookup;
    }
}
