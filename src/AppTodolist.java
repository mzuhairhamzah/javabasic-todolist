//Logic ToDoList 
/*
 * Menampilkan TodoList
 * Menambahkan TodoList
 * Menghapus TodoList
 */
public class AppTodolist {

    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        // System.out.println("Hello World!");
        // testShowTodoList();
        // testAddTodoList();
        // testRemoveTodoList();
        // testInput();
        // testViewShowTodoList();
        // testViewAddTodoList();
        // testViewRemoveTodoList();

        viewShowTodoList();
    }

    /*
     * Menampilkan todolist
     */
    public static void showTodoList() {
        System.out.println("TODOLIST");
        for (int i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus Java Dasar : Aplikasi TodoList";
        showTodoList();
    }

    /*
     * Menambahkan todolist
     */
    public static void addTodoList(String todo) {
        // cek apakah model isFull?
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                // model masih ada yang kosong
                isFull = false;
                break;
            }
        }
        // jika isFull, kita resize ukuran array 2x lipat
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }
        // tambahkan ke posisi yang data array nya NULL
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Contoh Todo Ke. " + i);
        }
        showTodoList();
    }

    /*
     * Menghapus todolist
     */
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];// logic menggeser urutan null ke belakang
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();

    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);
        var channel = input("Channel");
        System.out.println(channel);
    }

    /*
     * Menampilkan view todolist
     */
    public static void viewShowTodoList() {
        while (true) {

            showTodoList();

            System.out.println("Menu : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("q. Keluar");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("q")){
                break;
            }else {
                System.out.println("Pilihan Tidak Ada!");
            }
        }
    }
    public static void testViewShowTodoList(){
        for (int i = 0; i < 5; i++) {
            addTodoList("Contoh todolist : " + (i+1));
        }
        viewShowTodoList();
    }

    /*
     * Menampilkan view add todolist
     */
    public static void viewAddTodoList() {
        System.out.println("Menambah TODOLIST");
        var todo = input("Todo (Pilih q Jika Batal)");

        if (todo.equals("q")) {
            //batal
        } else {
            addTodoList(todo);
        }
    }
    public static void testViewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");

        viewAddTodoList();

        showTodoList();
    }

    /*
     * Menampilkan view remove todolist
     */
    public static void viewRemoveTodoList() {
        System.out.println("Menghapus TODOLIST");
        var number = input("Nomor yang Dihapus [Pilih q Jika Batal]");

        if (number.equals("q")) {
            //bata;
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal Menghapus Todolist : " + number);
            }
            
        }
    }
    public static void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
