package boottiful.spring3.springbootfeatures;

public class Java21Fetures {

    String displayUserForLoan(Loan loan) {
        // way 1
        /*if (loan instanceof SecuredLoan) {
            var sl = (SecuredLoan) loan;
            return "hey! good job! well done.";
        }
        if (loan instanceof UnsecuredLoan) {
            var usl = (UnsecuredLoan) loan;
            return "ooh! that " + usl.interest() + " % interest looks like it's going to hurt!";
        }*/

        // way 2 (pattern matching)
        /*if (loan instanceof SecuredLoan sl) {
            return "hey! good job! well done.";
        }
        if (loan instanceof UnsecuredLoan usl) {
            return "ooh! that " + usl.interest() + " % interest looks like it's going to hurt!";
        }*/

        //return null;

        // way 3 (pattern matching) (new switch)
        /*return switch (loan) {
            case UnsecuredLoan usl -> "ooh! that " + usl.interest() + " % interest looks like it's going to hurt!";
            case SecuredLoan sl -> "hey! good job! well done.";
        };*/

        // way 4 (pattern matching) (new switch)
        return switch (loan) {
            case UnsecuredLoan(var interest) -> "ooh! that " + interest + " % interest looks like it's going to hurt!";
            case SecuredLoan sl -> "hey! good job! well done.";
        };
    }
}

// new types in 21
sealed interface Loan permits SecuredLoan, UnsecuredLoan {

}

final class SecuredLoan implements Loan {
}

// new types in 21
record UnsecuredLoan(float interest) implements Loan {
}
