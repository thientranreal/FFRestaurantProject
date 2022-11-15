import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class BranchManage implements ReadWriteFile{
    private int amount;
    private Branch[] branchArray;
    private static Scanner sc = new Scanner(System.in);

    public BranchManage() {
    }

    public BranchManage(int amount) {
        if (amount > 0) {
            this.amount = amount;
            branchArray = new Branch[amount];
        }
    }

    public BranchManage(int amount, Branch[] branchArray) {
        this.amount = amount;
        this.branchArray = branchArray;
    }

    public int getAmount() {
        return amount;
    }

    public Branch[] getBranchArray() {
        return branchArray;
    }

    public void input() {
        for (int i=0; i < amount; i++) {
            branchArray[i] = new Branch();
            branchArray[i].input();
        }
    }

    @Override
    public void readFile(String filename) {
        try {
            String[] data;
            File file_url = new File(filename);
            String line = "";
            int i = 0;

            InputStream inputStream = new FileInputStream(file_url);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            // Đọc số lượng của mảng từ file gán vào amount, khởi tạo mảng employee mới
            amount = Integer.parseInt(reader.readLine());
            branchArray = new Branch[amount];

            // Đọc dữ liệu từ FILE
            while((line = reader.readLine()) != null) {
                data = line.split("[|]");
                branchArray[i] = new Branch();
                branchArray[i].setId(data[0]);
                branchArray[i].setName(data[1]);
                branchArray[i].setAddress(data[2]);
                branchArray[i].setOpenningdate(data[3]);
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
        if (branchArray == null) {
            System.out.println("Chưa tạo danh sách chi nhánh.");
            return;
        }
        String dsheader = String.format("%-10s|%-20s|%-50s|%-12s\n", "MaCN", "TenCN", "Dia Chi", "Ngay Mo Cua");

        try {
            File file = new File(filename);
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            // ghi file
            // ghi danh sach khach hang ra file
            outputStreamWriter.write(dsheader);
            for (Branch br : branchArray) {
                outputStreamWriter.write(br.toString() + "\n");
            }
            // end ghi file
            outputStreamWriter.flush();
            System.out.println("Đã ghi được file chi nhánh.");
        } catch (FileNotFoundException e) {
            System.out.println("Không mở được file.");
        } catch (IOException e) {
            System.out.println("Không ghi được file.");
        }
    }

    public void show() {
        if (branchArray == null) {
            System.out.println("Chưa tạo danh sách chi nhánh.");
            return;
        }
        System.out.printf("%-10s|%-20s|%-50s|%-12s\n", "MaCN", "TenCN", "Dia Chi", "Ngay Mo Cua");
        for (Branch br : branchArray) {
            System.out.println(br.toString());
        }
    }
    public Branch findBranch(String id) {
        for (Branch br : branchArray) {
            if (br.getId().compareToIgnoreCase(id) == 0) { return br; }
        }
        return null;
    }
    public void findBranchByName(String name) {
        if (branchArray == null) {
            System.out.println("Chưa tạo danh sách chi nhánh.");
            return;
        }
        System.out.printf("%-10s|%-20s|%-50s|%-12s\n", "MaCN", "TenCN", "Dia Chi", "Ngay Mo Cua");
        for (Branch br : branchArray) {
            if (br.getName().compareToIgnoreCase(name) == 0) {
                System.out.println(br.toString());
            }
        }
    }
    public void remove(String id) {
        if (branchArray == null) {
            System.out.println("Chưa tạo danh sách chi nhánh.");
            return;
        }
        // kiem tra pt muon xoa co ton tai trong mang thay khong
        if (findBranch(id) == null) {
            System.out.println("Chi nhánh không tồn tại.");
            return;
        }
        int j = 0;
        amount = amount - 1;
        Branch[] copy = new Branch[amount];
        // kiểm tra những phần tử trong array nếu là pt không muốn xóa thì sẽ copy vào mảng copy
        for (int i = 0; i < branchArray.length; i++) {
            if (branchArray[i].getId().compareToIgnoreCase(id) != 0) {
                copy[j++] = branchArray[i];
            }
        }
        branchArray = copy;
    }
    public void add(Branch br) {
        // nếu chưa có danh sách thì sẽ tạo ra danh sách mới
        if (branchArray == null) {
            amount = 1;
            branchArray = new Branch[amount];
            branchArray[0] = br;
            return;
        }
        // tăng số lượng lên 1 và copy các pt trong mảng sang mảng mới
        amount = amount + 1;
        branchArray = Arrays.copyOf(branchArray, amount);
        // pt cuối cùng là branch muốn thêm vào mảng
        branchArray[amount - 1] = br;
    }
    public void edit(String id) {
        if (branchArray == null) {
            System.out.println("Chưa tạo danh sách chi nhánh.");
            return;
        }
        if (findBranch(id) == null) {
            System.out.println("Chi nhánh không tồn tại.");
            return;
        }
        // lấy vị trí pt muốn sửa trong mảng gán vị trí vào i
        int i, chon;
        for (i = 0; i < amount; i++) {
            if (branchArray[i].getId().compareToIgnoreCase(id) == 0) {
                break;
            }
        }
        while (true) {
            System.out.printf("1. Sửa mã chi nhánh.\n");
            System.out.printf("2. Sửa tên chi nhánh.\n");
            System.out.printf("3. Sửa địa chỉ chi nhánh.\n");
            System.out.printf("4. Sửa ngày khai trương.\n");
            System.out.printf("Hãy chọn thông tin muốn sửa.\n");
            chon = Integer.parseInt(sc.nextLine());
            if (chon <= 0 || chon > 4) { break; }
            switch (chon) {
                case 1:
                    System.out.print("Hãy nhập mã chi nhánh: ");
                    branchArray[i].setId(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Hãy nhập tên chi nhánh: ");
                    branchArray[i].setName(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Hãy nhập địa chỉ chi nhánh: ");
                    branchArray[i].setAddress(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Hãy nhập ngày khai trương: ");
                    branchArray[i].setOpenningdate(sc.nextLine());
                    break;
            }
        }
    }
}
