class Main {
    public static void main(String[] args) throws Exception {
        Login loginForm = new Login();
        try {
            loginForm.show();
        } finally {

            System.out.println("Unhandled Exception occured");
        }

    }
}
