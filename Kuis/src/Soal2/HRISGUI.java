package Soal2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HRISGUI extends JFrame {
    private JFrame frame;
    private JComboBox<String> departementComboBox;
    private JTextField nameField;
    private JTextField dateOfBirthField;
    private JComboBox<String> positionComboBox;
    private JButton addEmployeeButton;
    private JButton cancelButton;
    private JTextArea displayArea;
    private JTextField findIdField;
    private JButton addButton;
    private JButton showAllButton;
    private List<Employee> employees;

    public HRISGUI() {
        employees = new ArrayList<>();

        frame = new JFrame("HRIS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        showMainPanel();
        frame.add(showMainPanel(), BorderLayout.CENTER);
        frame.pack();
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    private JPanel showMainPanel() {
        addButton = new JButton("Add Data");
        showAllButton = new JButton("Show Data");

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(showAllButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showInputPanel());
            }
        });

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showAllDataPanel());
            }
        });

        return buttonPanel;
    }

    private JPanel showAllDataPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new GridLayout(1, 1));

        findIdField = new JTextField(15);
        topPanel.add(findIdField);

        cancelButton = new JButton("Cancel");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(cancelButton);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showMainPanel());
            }
        });

        StringBuilder strBuilder = new StringBuilder();
        for (Employee employee : employees) {
            strBuilder.append(employee.toString()).append("\n");
        }

        displayArea = new JTextArea(strBuilder.toString());
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);
        return panel;
    }


    private void repaintPanel(JPanel newPanel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(newPanel);
        frame.revalidate();
        frame.repaint();
    }

    private JPanel showInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(7, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(15);

        JLabel dateOfBirthLabel = new JLabel("Date of Birth (DDMMYYYY):");
        dateOfBirthField = new JTextField(15);

        JLabel departementLabel = new JLabel("Department:");
        String[] departments = Employee.getDepartment();
        departementComboBox = new JComboBox<>(departments);

        JLabel positionLabel = new JLabel("Position:");
        String[] positions = {"Manager", "Developer", "HR Staff"};
        positionComboBox = new JComboBox<>(positions);

        addEmployeeButton = new JButton("Add Data");
        JButton backButton = new JButton("Back");

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(dateOfBirthLabel);
        inputPanel.add(dateOfBirthField);
        inputPanel.add(departementLabel);
        inputPanel.add(departementComboBox);
        inputPanel.add(positionLabel);
        inputPanel.add(positionComboBox);
        inputPanel.add(new JLabel());
        inputPanel.add(addEmployeeButton);
        inputPanel.add(new JLabel());
        inputPanel.add(backButton);

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String dateOfBirth = dateOfBirthField.getText();
                String department = departementComboBox.getSelectedItem().toString();
                String position = positionComboBox.getSelectedItem().toString();

                Employee newEmployee;
                switch (position) {
                    case "Manager":
                        newEmployee = new Manager(name, dateOfBirth, department);
                        break;
                    case "Developer":
                        newEmployee = new Developer(name, dateOfBirth, department);
                        break;
                    case "HR Staff":
                        newEmployee = new HRStaff(name, dateOfBirth, department);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + position);
                }

                employees.add(newEmployee);
                JOptionPane.showMessageDialog(HRISGUI.this, "Employee added: " + newEmployee.toString());
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showMainPanel());
            }
        });

        return inputPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HRISGUI();
            }
        });
    }
}
