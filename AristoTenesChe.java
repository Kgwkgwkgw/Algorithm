import java.util.Arrays;

public class AristoTenesChe {
	short[] sieve= new short[(201+7)/8];
	public AristoTenesChe() {
		Arrays.fill(sieve, (short)(255));
		setNotPrime(0);
		setNotPrime(1);
		int prime = 2;
		for(int i= 2;i<=Math.sqrt(200);i++) {
			if(isPrime(i)) {
				for(int j=i*i;j<=200;j+=i) {
					setNotPrime(j);
				}
			}
		}
	}
	public boolean isPrime(int k ) {
		return ((sieve[k>>3])&(1 << (k&7)))>0 ? true:false;
	}
	public void setNotPrime(int k) {
		sieve[k>>3] &= ~( 1 << (k&7));
	}
	public static void main(String[] args) {
		AristoTenesChe aristoTenesChe = new AristoTenesChe();
		System.out.println(aristoTenesChe.isPrime(2));
		System.out.println(aristoTenesChe.isPrime(197));
	}
}
