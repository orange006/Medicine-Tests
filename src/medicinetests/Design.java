package medicinetests;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import medicinetests.model.General;

public class Design extends javax.swing.JFrame {

    private final Timer timer;
    private int x = 0;

    private int countRightAnswers = 0;

    private ArrayList<Integer> btnNumber = new ArrayList<>();

    private ArrayList<Boolean> answersState = new ArrayList<>();

    private ArrayList<String> answererList = new ArrayList<>();

    public Design() {
        initComponents();

        getContentPane().setBackground(Color.WHITE);

        timer = new Timer(1000, new TimerTick());
        timer.start();

        jScrollPane2.setVisible(false);
        btn_check.setVisible(false);
        label_result.setVisible(false);
        btn_exit.setVisible(false);

        makeProgram();
    }

    private void saveData() {
        ArrayList<General> data = new ArrayList<>();
        data.addAll(MedicineTests.firstSection);
        data.addAll(MedicineTests.secondSection);
        data.addAll(MedicineTests.thirdSection);

        int size = 0;

        for (int i = 0; i < btnNumber.size(); i++) {

            List<Map<String, Boolean>> answer = data.get(i).getAnswers();
            size++;
            for (int j = 0; j < answer.size(); j++) {
                Map<String, Boolean> map = answer.get(j);

                Collection<Boolean> answerState = map.values();

                Boolean firstState = answerState.stream().findFirst().get();

                answersState.add(firstState);
            }
        }

        for (int i = 0; i < size; i++) {
            if (answersState.get(i * 5 + btnNumber.get(i) - 1) == true) {
                countRightAnswers++;
            }
        }

//        for (int i = 0; i < size; i++) {
//            List<Map<String, Boolean>> answer = data.get(i).getAnswers();
//            for (int j = 0; j < answer.size(); j++) {
//                
//                Map<String, Boolean> map = answer.get(j);
//
//                Collection<Boolean> answerState = map.values();
//                
//                String answerText = map.keySet().stream().findFirst().get();
//
//                answererList.add(answerText);
//            }
//        }
//        
//        for (int i = 0; i < size; i++) {
//            if (answersState.get(i * 5 + btnNumber.get(i) - 1) == true) {
//                
//                String beforeTrue = answererList.get(i * 5 + btnNumber.get(i) - 2);
//                
//                answererList.set(i * 5 + btnNumber.get(i) - 2, beforeTrue + "$");
//            }
//        }
    }

    private void makeProgram() {
        rbtn1.setSelected(false);
        rbtn2.setSelected(false);
        rbtn3.setSelected(false);
        rbtn4.setSelected(false);
        rbtn5.setSelected(false);

        btn_answer.setEnabled(false);

        if (btnNumber.size() == (MedicineTests.firstSection.size() + MedicineTests.secondSection.size() + MedicineTests.thirdSection.size())) {
            btn_end.doClick();
            return;
        }

        if (x == 0) {
            btn_back.setEnabled(false);
        }

        if (x > 0) {
            btn_back.setEnabled(true);
        }

        if (!btnNumber.isEmpty() && btnNumber.size() != x) {
            if (btnNumber.get(x) == 1) {
                rbtn1.setSelected(true);
            }
            if (btnNumber.get(x) == 2) {
                rbtn2.setSelected(true);
            }
            if (btnNumber.get(x) == 3) {
                rbtn3.setSelected(true);
            }
            if (btnNumber.get(x) == 4) {
                rbtn4.setSelected(true);
            }
            if (btnNumber.get(x) == 5) {
                rbtn5.setSelected(true);
            }
        }

        label_counter.setText((x + 1) + " з " + (MedicineTests.firstSection.size() + MedicineTests.secondSection.size() + MedicineTests.thirdSection.size()));

        List<JRadioButton> radioButtons = Arrays.asList(rbtn1, rbtn2, rbtn3, rbtn4, rbtn5);

        if (x < 60) {
            setTextToComponents(MedicineTests.firstSection, radioButtons, x);
        } else if (x >= 60 && x < 120) {
            setTextToComponents(MedicineTests.secondSection, radioButtons, x - MedicineTests.secondSection.size());
        } else if (x >= 120) {
            setTextToComponents(MedicineTests.thirdSection, radioButtons, x - (MedicineTests.secondSection.size() + MedicineTests.thirdSection.size()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbtn2 = new javax.swing.JRadioButton();
        rbtn3 = new javax.swing.JRadioButton();
        rbtn4 = new javax.swing.JRadioButton();
        label_result = new javax.swing.JLabel();
        btn_exit = new javax.swing.JButton();
        btn_end = new javax.swing.JButton();
        label_question = new javax.swing.JLabel();
        label_counter = new javax.swing.JLabel();
        label_timer = new javax.swing.JLabel();
        btn_check = new javax.swing.JButton();
        rbtn5 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        btn_back = new javax.swing.JButton();
        btn_answer = new javax.swing.JButton();
        rbtn1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        rbtn2.setBackground(new java.awt.Color(255, 255, 255));
        rbtn2.setFont(new java.awt.Font("Roboto Light", 0, 16)); // NOI18N
        rbtn2.setText("Answer 2");
        rbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn2ActionPerformed(evt);
            }
        });

        rbtn3.setBackground(new java.awt.Color(255, 255, 255));
        rbtn3.setFont(new java.awt.Font("Roboto Light", 0, 16)); // NOI18N
        rbtn3.setText("Answer 3");
        rbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn3ActionPerformed(evt);
            }
        });

        rbtn4.setBackground(new java.awt.Color(255, 255, 255));
        rbtn4.setFont(new java.awt.Font("Roboto Light", 0, 16)); // NOI18N
        rbtn4.setText("Answer 4");
        rbtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn4ActionPerformed(evt);
            }
        });

        label_result.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        label_result.setText("Result");

        btn_exit.setBackground(new java.awt.Color(0, 0, 0));
        btn_exit.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        btn_exit.setForeground(new java.awt.Color(255, 255, 255));
        btn_exit.setText("Вийти");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        btn_end.setBackground(new java.awt.Color(0, 0, 0));
        btn_end.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        btn_end.setForeground(new java.awt.Color(255, 255, 255));
        btn_end.setText("Завершити тест");
        btn_end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_endActionPerformed(evt);
            }
        });

        label_question.setFont(new java.awt.Font("Roboto Light", 0, 16)); // NOI18N
        label_question.setText("QuestionsIsHere");
        label_question.setAutoscrolls(true);

        label_counter.setFont(new java.awt.Font("Roboto Light", 1, 13)); // NOI18N
        label_counter.setForeground(new java.awt.Color(102, 102, 102));
        label_counter.setText("Counter");

        label_timer.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        label_timer.setForeground(new java.awt.Color(255, 51, 51));
        label_timer.setText("180:00");

        btn_check.setBackground(new java.awt.Color(0, 0, 0));
        btn_check.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        btn_check.setForeground(new java.awt.Color(255, 255, 255));
        btn_check.setText("Перевірити відповіді");
        btn_check.setToolTipText("");
        btn_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_checkActionPerformed(evt);
            }
        });

        rbtn5.setBackground(new java.awt.Color(255, 255, 255));
        rbtn5.setFont(new java.awt.Font("Roboto Light", 0, 16)); // NOI18N
        rbtn5.setText("Answer 5");
        rbtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn5ActionPerformed(evt);
            }
        });

        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jScrollPane2.setViewportView(jTextPane1);

        btn_back.setBackground(new java.awt.Color(0, 0, 0));
        btn_back.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Повернутися");
        btn_back.setActionCommand("Назад");
        btn_back.setPreferredSize(new java.awt.Dimension(81, 23));
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_answer.setBackground(new java.awt.Color(0, 0, 0));
        btn_answer.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        btn_answer.setForeground(new java.awt.Color(255, 255, 255));
        btn_answer.setText("Відповісти");
        btn_answer.setPreferredSize(new java.awt.Dimension(81, 23));
        btn_answer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_answerActionPerformed(evt);
            }
        });

        rbtn1.setBackground(new java.awt.Color(255, 255, 255));
        rbtn1.setFont(new java.awt.Font("Roboto Light", 0, 16)); // NOI18N
        rbtn1.setText("Answer 1");
        rbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_timer))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label_counter, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(label_result)
                                        .addComponent(label_question)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_answer, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(263, 263, 263)
                                .addComponent(btn_end, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtn2)
                            .addComponent(rbtn3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtn4)
                            .addComponent(rbtn5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_check, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_counter)
                            .addComponent(label_timer))
                        .addGap(31, 31, 31)
                        .addComponent(label_question)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_result)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtn1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtn2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtn3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtn4)
                        .addGap(3, 3, 3)
                        .addComponent(rbtn5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_answer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_end, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_check, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn2ActionPerformed
        if (rbtn2.isSelected()) {
            rbtn1.setSelected(false);
            rbtn3.setSelected(false);
            rbtn4.setSelected(false);
            rbtn5.setSelected(false);
            btn_answer.setEnabled(true);
        } else {
            rbtn1.setEnabled(true);
            rbtn3.setEnabled(true);
            rbtn4.setEnabled(true);
            rbtn5.setEnabled(true);
            btn_answer.setEnabled(false);
        }
    }//GEN-LAST:event_rbtn2ActionPerformed

    private void rbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn3ActionPerformed
        if (rbtn3.isSelected()) {
            rbtn2.setSelected(false);
            rbtn1.setSelected(false);
            rbtn4.setSelected(false);
            rbtn5.setSelected(false);
            btn_answer.setEnabled(true);
        } else {
            rbtn2.setEnabled(true);
            rbtn1.setEnabled(true);
            rbtn4.setEnabled(true);
            rbtn5.setEnabled(true);
            btn_answer.setEnabled(false);
        }
    }//GEN-LAST:event_rbtn3ActionPerformed

    private void rbtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn4ActionPerformed
        if (rbtn4.isSelected()) {
            rbtn2.setSelected(false);
            rbtn3.setSelected(false);
            rbtn1.setSelected(false);
            rbtn5.setSelected(false);
            btn_answer.setEnabled(true);
        } else {
            rbtn2.setEnabled(true);
            rbtn3.setEnabled(true);
            rbtn1.setEnabled(true);
            rbtn5.setEnabled(true);
            btn_answer.setEnabled(false);
        }
    }//GEN-LAST:event_rbtn4ActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_endActionPerformed
        saveData();
        label_result.setVisible(true);
        label_result.setText("Ви відповіли вірно на " + countRightAnswers
                + " запитань із " + (MedicineTests.firstSection.size()
                + MedicineTests.secondSection.size() + MedicineTests.thirdSection.size()) + ".");

        timer.stop();
        rbtn1.setVisible(false);
        rbtn2.setVisible(false);
        rbtn3.setVisible(false);
        rbtn4.setVisible(false);
        rbtn5.setVisible(false);
        btn_answer.setVisible(false);
        btn_back.setVisible(false);
        label_counter.setVisible(false);
        label_question.setVisible(false);

        label_timer.setVisible(true);
        btn_check.setVisible(true);
        btn_exit.setVisible(true);

        this.setSize(480, 270);
        this.setLocationRelativeTo(null);
        setLayout(null);

        label_result.setSize(350, 35);
        btn_exit.setSize(100, 35);
        btn_check.setSize(180, 35);

        label_result.setLocation(40, 20);
        btn_exit.setLocation(330, 165);
        btn_check.setLocation(145, 165);
    }//GEN-LAST:event_btn_endActionPerformed

    private void btn_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_checkActionPerformed
        if (btnNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ви не дали відповіді хоча б на одне запитання!");
            return;
        }

        btn_answer.setVisible(false);
        btn_check.setVisible(false);
        btn_end.setVisible(false);
        label_result.setVisible(false);
        label_timer.setVisible(false);
        btn_exit.setVisible(false);

        jScrollPane2.setVisible(true);

        String viewResult = "";

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        if (width > 1915) {
            width = 1366;
            height = 768;
        }

        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        setLayout(null);

        jScrollPane2.setVisible(true);
        jScrollPane2.setSize(width - 4, height - 32);
        jScrollPane2.setLocation(0, 0);

        for (int i = 0; i < btnNumber.size(); i++) {
            if (i < 60) {
                if(i == 0) {
                    viewResult += "Перша секція запитань.\n\n";
                }
                
                viewResult += outResult(MedicineTests.firstSection, i);
            } else if (i >= 60 && i < 120) {
                if(i == 60) {
                    viewResult += "Друга секція запитань.\n\n";
                }
                
                viewResult += outResult(MedicineTests.secondSection, i - MedicineTests.secondSection.size());
            } else if (i >= 120) {
                if(i == 120) {
                    viewResult += "Третя секція запитань.\n\n";
                }
                
                viewResult += outResult(MedicineTests.thirdSection, i - (MedicineTests.secondSection.size() + MedicineTests.thirdSection.size()));
            }
        }

        jTextPane1.setText(viewResult);
    }//GEN-LAST:event_btn_checkActionPerformed

    private void rbtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn5ActionPerformed
        if (rbtn5.isSelected()) {
            rbtn2.setSelected(false);
            rbtn3.setSelected(false);
            rbtn4.setSelected(false);
            rbtn1.setSelected(false);
            btn_answer.setEnabled(true);
        } else {
            rbtn2.setEnabled(true);
            rbtn3.setEnabled(true);
            rbtn4.setEnabled(true);
            rbtn1.setEnabled(true);
            btn_answer.setEnabled(false);
        }
    }//GEN-LAST:event_rbtn5ActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        x--;
        makeProgram();

        btn_answer.setEnabled(true);

        setPreviousRadioButton();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_answerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_answerActionPerformed

        if (rbtn1.isSelected()) {
            if (!btnNumber.isEmpty() && btnNumber.size() != x) {
                btnNumber.remove(x);
            }
            btnNumber.add(x, 1);
        } else if (rbtn2.isSelected()) {
            if (!btnNumber.isEmpty() && btnNumber.size() != x) {
                btnNumber.remove(x);
            }
            btnNumber.add(x, 2);
        } else if (rbtn3.isSelected()) {
            if (!btnNumber.isEmpty() && btnNumber.size() != x) {
                btnNumber.remove(x);
            }
            btnNumber.add(x, 3);
        } else if (rbtn4.isSelected()) {
            if (!btnNumber.isEmpty() && btnNumber.size() != x) {
                btnNumber.remove(x);
            }
            btnNumber.add(x, 4);
        } else if (rbtn5.isSelected()) {
            if (!btnNumber.isEmpty() && btnNumber.size() != x) {
                btnNumber.remove(x);
            }
            btnNumber.add(x, 5);
        }

        x++;
        makeProgram();
    }//GEN-LAST:event_btn_answerActionPerformed

    private void rbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn1ActionPerformed
        if (rbtn1.isSelected()) {
            rbtn2.setSelected(false);
            rbtn3.setSelected(false);
            rbtn4.setSelected(false);
            rbtn5.setSelected(false);
            btn_answer.setEnabled(true);
        } else {
            rbtn2.setEnabled(true);
            rbtn3.setEnabled(true);
            rbtn4.setEnabled(true);
            rbtn5.setEnabled(true);
            btn_answer.setEnabled(false);
        }
    }//GEN-LAST:event_rbtn1ActionPerformed

    private String outResult(ArrayList<General> list, int i) {
        String viewResult = "";

        String question = list
                .get(i)
                .getQuestion();

        viewResult += question + "\n\n";

        for (int j = 0; j < 5; j++) {
            String answerWithBrackets = list
                    .get(i)
                    .getAnswers()
                    .get(j)
                    .keySet()
                    .toString();

            String answer = removeBrackets(answerWithBrackets);
            viewResult += answer + '\n';
        }
        viewResult += '\n';

        return viewResult;
    }

    private void setTextToComponents(ArrayList<General> list, List<JRadioButton> radioButtons, int y) {
        label_question.setText("<html><p style=\"width:530px\">" + list.get(y).getQuestion() + "</p></html>");

        for (int i = 0; i < 5; i++) {
            String answerWithBrackets = list
                    .get(y)
                    .getAnswers()
                    .get(i)
                    .keySet()
                    .toString();

            String answer = removeBrackets(answerWithBrackets);
            radioButtons.get(i).setText(answer);
        }
    }

    private void setPreviousRadioButton() {
        if (btnNumber.get(x) == 1) {
            rbtn1.setSelected(true);
        }
        if (btnNumber.get(x) == 2) {
            rbtn2.setSelected(true);
        }
        if (btnNumber.get(x) == 3) {
            rbtn3.setSelected(true);
        }
        if (btnNumber.get(x) == 4) {
            rbtn4.setSelected(true);
        }
        if (btnNumber.get(x) == 5) {
            rbtn5.setSelected(true);
        }
    }

    private String removeBrackets(String answer) {
        return answer.substring(1, answer.length() - 1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Design().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_answer;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_check;
    private javax.swing.JButton btn_end;
    private javax.swing.JButton btn_exit;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel label_counter;
    private javax.swing.JLabel label_question;
    private javax.swing.JLabel label_result;
    private javax.swing.JLabel label_timer;
    private javax.swing.JRadioButton rbtn1;
    private javax.swing.JRadioButton rbtn2;
    private javax.swing.JRadioButton rbtn3;
    private javax.swing.JRadioButton rbtn4;
    private javax.swing.JRadioButton rbtn5;
    // End of variables declaration//GEN-END:variables

    private class TimerTick implements ActionListener {

        int countdown = 180 * 60;

        @Override
        public void actionPerformed(ActionEvent e) {
            label_timer.setVisible(true);
            countdown--;

            int min = countdown / 60;
            int sec = countdown % 60;

            label_timer.setText(String.valueOf(min + ":" + sec));

            if (countdown % 60 < 10) {
                label_timer.setText(String.valueOf(min + ":0" + sec));
            }

            if (countdown == 0) {
                label_timer.setVisible(true);
                timer.stop();
                btn_end.doClick();
            }
        }
    }
}
