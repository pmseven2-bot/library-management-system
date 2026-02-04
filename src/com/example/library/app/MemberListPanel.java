package com.example.library.app;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import com.example.library.app.MemberController;
import com.example.library.app.Member;

public class MemberListPanel extends JPanel {

    private final MemberController controller;

    public MemberListPanel(MemberController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());

        String[] columns = {"ID", "Name", "Join Date", "Level"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        controller.getAllMembers().forEach(member -> {
            model.addRow(new Object[]{
                    member.getId(),
                    member.getName(),
                    member.getJoined(),
                    member.getLevel()
            });
        });

        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
