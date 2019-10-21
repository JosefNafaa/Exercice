package service;

public class Traitement {
	
	/**
	 * La fonction isNumber vérifie si le nombre passé en String est un vrai nombre.
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isNumber(String number) {
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	/**
	 * La fonction isDividedBy retourn les mots qui montrent les chiffres qui
	 * divisent le nombre en question , si le nombre n'est pas divisible pas ces
	 * chiffres elle retourn le nombre .
	 * 
	 * @param number
	 * @return
	 */
	public static StringBuilder isDivididedBy(int number) {
		StringBuilder sb = new StringBuilder();
		int div = 0;

		if (number % 3 == 0) {
			sb.append("Foo");
			div++;
		}
		if (number % 5 == 0) {
			sb.append("Bar");
			div++;
		}
		if (number % 7 == 0) {
			sb.append("Qix");
			div++;
		}
		if (div == 0) {
			sb.append(number);
		}
		return sb;

	}

	/**
	 * La fonction conatinsDividedNumber permet de verifier si le nombre contient
	 * les chiffres 3/5/7
	 * 
	 */
	public static boolean containsDividedNumber(String number) {
		char ch3 = '3';
		char ch5 = '5';
		char ch7 = '7';
		for (int i = 0; i < number.length(); i++) {
			if ((number.charAt(i) == ch3) || (number.charAt(i) == ch5) || (number.charAt(i) == ch7))
				return true;
		}
		return false;

	}

	/**
	 * La fonction replaceNumber remplace les digits par les mots equivalents ainsi
	 * que la valeur du nombre 0 o par *
	 * 
	 * @param number
	 * @return
	 */
	public static StringBuilder replaceNumber(String number) {
		StringBuilder sb = new StringBuilder();
		/**
		 * Premier teste à faire , on doit vérifier si le nombre ecrit en String est un
		 * vrai nombre
		 */
		if (!isNumber(number)) {
			return sb.append("nombre faux");
		}

		/**
		 * La je teste si le nombre n'est pas divisbile par aucun chiffre . La fonction
		 * isDividedBy si elle retourne le nombre initiale cela veut dire que le nombre
		 * n'est pas divisible
		 * 
		 */
		if (number.equals(isDivididedBy(Integer.parseInt(number)).toString())) {
          /**
           * Dans le cas ou le nombre n'est pas divisble , je commence a remplacer , il y a deux cas, soit le nombre contient les chiffres , ou non
           * Quand le nombre ne contient pas les chiffres, tout ce qu'il faut faire c'est de remplacer les 0 par *
           * 
           */
			if (!containsDividedNumber(String.valueOf(number))) {
				for (int i = 0; i < number.length(); i++) {
					if (number.charAt(i) == '0') {
						sb.append('*');

					} else {
						sb.append(number.charAt(i));
					}

				}

			} 
			/**
			 * Dans le cas ou le nombre n'est pas divisble masi contient les chifres, il ne faut remplacer que les chiffres et le 0
			 */
			else {
				for (int i = 0; i < number.length(); i++) {
					if (number.charAt(i) == '3') {
						sb.append("Foo");
					}
					if (number.charAt(i) == '5') {
						sb.append("Bar");
					}
					if (number.charAt(i) == '7') {
						sb.append("Qix");
					} else if (number.charAt(i) == '0') {
						sb.append('*');

					}
				}
			}
		}
		/**
		 * Dans le cas ou le nombre contient les chiffres 3/5/7 , on commence par
		 * concatener mots equivalents des chiffres qui divisent le nombres puis on
		 * remplace les digits par leurs équivalents
		 */
		else {
			sb.append(isDivididedBy(Integer.parseInt(number)));
			for (int i = 0; i < number.length(); i++) {
				if (number.charAt(i) == '3') {
					sb.append("Foo");
				}
				if (number.charAt(i) == '5') {
					sb.append("Bar");
				}
				if (number.charAt(i) == '7') {
					sb.append("Qix");
				} else if (number.charAt(i) == '0') {
					sb.append('*');

				}
			}

		}

		return sb;
	}

}
