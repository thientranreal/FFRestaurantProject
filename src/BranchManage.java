import java.util.Arrays;
import java.util.Scanner;

public class BranchManage {
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
    public void show() {
        System.out.printf("%-10s|%-20s|%-50s|%-12s\n", "MaCN", "TenCN", "Dia Chi", "Ngay Mo Cua");
        for (Branch br : branchArray) {
            System.out.println(br.toString());
        }
    }
    public Branch findBranch(String id) {
        for (Branch br : branchArray) {
            if (br.getId().compareToIgnoreCase(id) == 0) { return br; }
        }
        return new Branch();
    }
    public void findBranchByName(String name) {
        for (Branch br : branchArray) {
            if (br.getName().compareToIgnoreCase(name) == 0) {
                System.out.println(br.toString());
            }
        }
    }
    public void remove(String id) {
        // kiem tra pt muon xoa co ton tai trong mang thay khong
        for (int i = 0; i < amount; i++) {
            if (branchArray[i].getId().compareToIgnoreCase(id) == 0) { break; }
            if (i == amount - 1) {
                System.out.println("Chi nhánh không tồn tại.");
                return;
            } // neu toi pt cuoi cung ma chua thoat khoi vong lap thi return khong remove
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
        // tăng số lượng lên 1 và copy các pt trong mảng sang mảng mới
        amount = amount + 1;
        branchArray = Arrays.copyOf(branchArray, amount);
        // pt cuối cùng là branch muốn thêm vào mảng
        branchArray[amount - 1] = br;
    }
    public void edit(String id) {
        // lấy vị trí pt muốn sửa trong mảng gán vị trí vào i
        int i, chon;
        for (i = 0; i < amount; i++) {
            if (branchArray[i].getId().compareToIgnoreCase(id) == 0) {
                break;
            }
            if (i == amount - 1) {
                System.out.println("Chi nhánh không tồn tại.");
                return;
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
