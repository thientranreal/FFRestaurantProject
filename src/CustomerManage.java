import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class CustomerManage implements ReadWriteFile{
    private int amount;
    private Customer[] customerArray;
    private static Scanner sc = new Scanner(System.in);

    public CustomerManage() {
    }

    public CustomerManage(int amount) {
        if (amount > 0) {
            this.amount = amount;
            customerArray = new Customer[amount];
        }
    }

    public CustomerManage(int amount, Customer[] customerArray) {
        this.amount = amount;
        this.customerArray = customerArray;
    }

    public int getAmount() {
        return amount;
    }

    public Customer[] getCustomerArray() {
        return customerArray;
    }

    public void input() {
        for (int i=0; i < amount; i++) {
            customerArray[i] = new Customer();
            customerArray[i].input();
        }
    }

    @Override
    public void readFile(String filename) {
        String[] data;
        String line = "";
        int i = 0;

        try {
            File file_url = new File(filename);
            InputStream inputStream = new FileInputStream(file_url);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            // Đọc số lượng của mảng từ file gán vào amount, khởi tạo mảng employee mới
            amount = Integer.parseInt(reader.readLine());
            customerArray = new Customer[amount];

            // Đọc dữ liệu từ FILE
            while((line = reader.readLine()) != null) {
                data = line.split("[|]");
                customerArray[i] = new Customer();
                customerArray[i].setId(data[0]);
                customerArray[i].setCustomer_type(data[1]);
                customerArray[i].setName(data[2]);
                customerArray[i].setBirthyear(Integer.parseInt(data[3]));
                customerArray[i].setGender(data[4]);
                customerArray[i].setAddress(data[5]);
                customerArray[i].setPhonenumber(data[6]);
                customerArray[i].setEmail(data[7]);
                ++i;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không mở được file.");
        } catch (IOException e) {
            System.out.println("Không đọc được file.");
        }
    }

    @Override
    public void writeFile(String filename) {
        if (customerArray == null) {
            System.out.println("Chưa tạo danh sách khách hàng.");
            return;
        }
        String dsheader = String.format("%-10s|%-10s|%-25s|%-6s|%-8s|%-50s|%-15s|%-20s\n", "MaKH", "LoaiKH", "Ho Ten", "NS", "GT", "Dia Chi", "SDT", "Email");

        try {
            File file = new File(filename);
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            // ghi file
            // ghi danh sach khach hang ra file
            outputStreamWriter.write(dsheader);
            for (Customer cus : customerArray) {
                outputStreamWriter.write(cus.toString() + "\n");
            }
            // end ghi file
            outputStreamWriter.flush();
            System.out.println("Đã ghi được file khách hàng.");
        } catch (FileNotFoundException e) {
            System.out.println("Không mở được file.");
        } catch (IOException e) {
            System.out.println("Không ghi được file.");
        }
    }

    public void show() {
        if (customerArray == null) {
            System.out.println("Chưa tạo danh sách khách hàng.");
            return;
        }
        System.out.printf("%-10s|%-10s|%-25s|%-6s|%-8s|%-50s|%-15s|%-20s\n", "MaKH", "LoaiKH", "Ho Ten", "NS", "GT", "Dia Chi", "SDT", "Email");
        for (Customer cus : customerArray) {
            System.out.println(cus.toString());
        }
    }
    public Customer findCustomer(String id) {
        for (Customer cus : customerArray) {
            if (cus.getId().compareToIgnoreCase(id) == 0) { return cus; }
        }
        return null;
    }
    public void findCustomerByName(String name) {
        if (customerArray == null) {
            System.out.println("Chưa tạo danh sách khách hàng.");
            return;
        }
        System.out.printf("%-10s|%-10s|%-25s|%-6s|%-8s|%-50s|%-15s|%-20s\n", "MaKH", "LoaiKH", "Ho Ten", "NS", "GT", "Dia Chi", "SDT", "Email");
        for (Customer cus : customerArray) {
            if (cus.getName().compareToIgnoreCase(name) == 0) {
                System.out.println(cus.toString());
            }
        }
    }
    public void remove(String id) {
        if (customerArray == null) {
            System.out.println("Chưa tạo danh sách khách hàng.");
            return;
        }
        // kiem tra pt muon xoa co ton tai trong mang thay khong
        if (findCustomer(id) == null) {
            System.out.println("Khách hàng không tồn tại.");
            return;
        }
        int j = 0;
        amount = amount - 1;
        Customer[] copy = new Customer[amount];
        // kiểm tra những phần tử trong array nếu là pt không muốn xóa thì sẽ copy vào mảng copy
        for (int i = 0; i < customerArray.length; i++) {
            if (customerArray[i].getId().compareToIgnoreCase(id) != 0) {
                copy[j++] = customerArray[i];
            }
        }
        customerArray = copy;
    }
    public void add(Customer cus) {
        // nếu chưa có danh sách thì sẽ tạo ra danh sách mới
        if (customerArray == null) {
            amount = 1;
            customerArray = new Customer[amount];
            customerArray[0] = cus;
            return;
        }
        // tăng số lượng lên 1 và copy các pt trong mảng sang mảng mới
        amount = amount + 1;
        customerArray = Arrays.copyOf(customerArray, amount);
        // pt cuối cùng là customer muốn thêm vào mảng
        customerArray[amount - 1] = cus;
    }
    public void edit(String id) {
        if (customerArray == null) {
            System.out.println("Chưa tạo danh sách khách hàng.");
            return;
        }
        // kiem tra pt muon xoa co ton tai trong mang thay khong
        if (findCustomer(id) == null) {
            System.out.println("Khách hàng không tồn tại.");
            return;
        }
        // lấy vị trí pt muốn sửa trong mảng gán vị trí vào i
        int i, chon;
        for (i = 0; i < amount; i++) {
            if (customerArray[i].getId().compareToIgnoreCase(id) == 0) {
                break;
            }
        }
        while (true) {
            System.out.printf("1. Sửa mã KH.\n");
            System.out.printf("2. Sửa họ tên.\n");
            System.out.printf("3. Sửa năm sinh.\n");
            System.out.printf("4. Sửa giới tính.\n");
            System.out.printf("5. Sửa địa chỉ.\n");
            System.out.printf("6. Sửa điện thoại.\n");
            System.out.printf("7. Sửa email.\n");
            System.out.printf("8. Sửa loại KH.\n");
            System.out.printf("Hãy chọn thông tin muốn sửa.\n");
            chon = Integer.parseInt(sc.nextLine());
            if (chon <= 0 || chon > 8) { break; }
            switch (chon) {
                case 1:
                    System.out.print("Hãy nhập mã khách hàng: ");
                    customerArray[i].setId(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Hãy nhập họ và tên: ");
                    customerArray[i].setName(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Hãy nhập năm sinh: ");
                    customerArray[i].setBirthyear(Integer.parseInt(sc.nextLine()));
                    break;
                case 4:
                    System.out.print("Hãy nhập giới tính: ");
                    customerArray[i].setGender(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Hãy nhập địa chỉ: ");
                    customerArray[i].setAddress(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Hãy nhập số điện thoại: ");
                    customerArray[i].setPhonenumber(sc.nextLine());
                    break;
                case 7:
                    System.out.print("Hãy nhập email: ");
                    customerArray[i].setEmail(sc.nextLine());
                    break;
                case 8:
                    System.out.print("Hãy nhập loại khách hàng (normal, bronze, gold, diamond): ");
                    customerArray[i].setCustomer_type(sc.nextLine());
                    break;
            }
        }
    }
}
