package com.mycompany.englishlearningapp.Proccess;

public enum ProficiencyLevel {
    BEGINNER(1),
    INTERMEDIATE(2),
    ADVANCED(3);

    private final int level; // Thuộc tính đại diện cho cấp độ

    // Constructor (phải là private hoặc mặc định)
    ProficiencyLevel(int level) {
        this.level = level;
    }

    // Phương thức lấy giá trị cấp độ
    public int getLevel() {
        return level;
    }

    // Phương thức chuyển từ số nguyên sang enum
    public static ProficiencyLevel fromLevel(int level) {
        for (ProficiencyLevel p : values()) { // values() trả về tất cả giá trị của enum
            if (p.level == level) {
                return p;
            }
        }
        throw new IllegalArgumentException("Không có cấp độ phù hợp: " + level);
    }
}

