import javax.swing.*;
import java.net.URL;
import java.util.*;

public class GUI extends javax.swing.JFrame {

   DefaultListModel<String> listModel = new DefaultListModel<>();
   DefaultListModel<String> listModelDummy = new DefaultListModel<>();

   DefaultComboBoxModel<String> movieComboBoxModelA = new DefaultComboBoxModel<>();
   DefaultComboBoxModel<String> movieComboBoxModelB = new DefaultComboBoxModel<>();
   DefaultComboBoxModel<String> movieComboBoxModelC = new DefaultComboBoxModel<>();
   DefaultComboBoxModel<String> movieComboBoxModelD = new DefaultComboBoxModel<>();
   DefaultComboBoxModel<String> movieComboBoxModelE = new DefaultComboBoxModel<>();

   Recommender recommender;
   static List<Movie> movies = Recommender.getMovies();
   static Random random = new Random();

   List<User> targetUsers = Recommender.getTargetUsers();
   User targetUser;
   int k = 0;
   int x = 0;

   public GUI() {
      initComponents();

      // Adding random movies to the comboboxes for dummy data
      List<Movie> tenRandomMovie = getRandomTenMovie();
      movieComboBoxModelA.addAll(tenRandomMovie.stream().map(Movie::getTitle).toList());
      movieComboBoxModelB.addAll(tenRandomMovie.stream().map(Movie::getTitle).toList());
      movieComboBoxModelC.addAll(tenRandomMovie.stream().map(Movie::getTitle).toList());
      movieComboBoxModelD.addAll(tenRandomMovie.stream().map(Movie::getTitle).toList());
      movieComboBoxModelE.addAll(tenRandomMovie.stream().map(Movie::getTitle).toList());

      // Setting app icon
      URL iconURL = getClass().getResource("favicon.png");
      assert iconURL != null;
      ImageIcon icon = new ImageIcon(iconURL);

      setIconImage(icon.getImage());

      // Adding target user id's to the combobox
      for (User user : targetUsers) {
         int userId = user.getUserID();
         targetUserComboBox.addItem(userId);
      }

   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated
   // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        targetUserComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        showCloseMoviesButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        recommendationsList = new javax.swing.JList<>();
        kTargetuserSpinner = new javax.swing.JSpinner();
        xTargetUserSpinner = new javax.swing.JSpinner();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        getRecommendationsForDummyUserButton = new javax.swing.JButton();
        movieComboBoxA = new javax.swing.JComboBox<>();
        movieComboBoxB = new javax.swing.JComboBox<>();
        movieComboBoxC = new javax.swing.JComboBox<>();
        movieComboBoxE = new javax.swing.JComboBox<>();
        movieComboBoxD = new javax.swing.JComboBox<>();
        ratingSliderA = new javax.swing.JSlider();
        ratingSliderB = new javax.swing.JSlider();
        ratingSliderC = new javax.swing.JSlider();
        ratingSliderE = new javax.swing.JSlider();
        ratingSliderD = new javax.swing.JSlider();
        kDummyUserSpinner = new javax.swing.JSpinner();
        xDummyUserSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 204, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TARGET USER");

        targetUserComboBox.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Similar Users :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Movies :");

        showCloseMoviesButton.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        showCloseMoviesButton.setText("SHOW RECOMMENDS");
        showCloseMoviesButton.setToolTipText("");
        showCloseMoviesButton.setRolloverEnabled(false);
        showCloseMoviesButton.setSelected(true);
        showCloseMoviesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCloseMoviesButtonActionPerformed(evt);
            }
        });

        recommendationsList.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        recommendationsList.setModel(listModel);
        jScrollPane2.setViewportView(recommendationsList);

        kTargetuserSpinner.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        kTargetuserSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        kTargetuserSpinner.setPreferredSize(new java.awt.Dimension(72, 25));
        kTargetuserSpinner.setSize(new java.awt.Dimension(72, 25));

        xTargetUserSpinner.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        xTargetUserSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        xTargetUserSpinner.setPreferredSize(new java.awt.Dimension(72, 25));

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(targetUserComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(xTargetUserSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kTargetuserSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(showCloseMoviesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(targetUserComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(kTargetuserSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(xTargetUserSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(showCloseMoviesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("User Recommends", kGradientPanel1);

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 153, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(51, 51, 255));
        kGradientPanel2.setPreferredSize(new java.awt.Dimension(746, 450));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Similar Users :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Movies :");

        jList1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jList1.setModel(listModelDummy);
        jScrollPane1.setViewportView(jList1);

        getRecommendationsForDummyUserButton.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        getRecommendationsForDummyUserButton.setText("SHOW");
        getRecommendationsForDummyUserButton.setToolTipText("");
        getRecommendationsForDummyUserButton.setRolloverEnabled(false);
        getRecommendationsForDummyUserButton.setSelected(true);
        getRecommendationsForDummyUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getRecommendationsForDummyUserButtonActionPerformed(evt);
            }
        });

        movieComboBoxA.setModel(movieComboBoxModelA);
        movieComboBoxA.setPreferredSize(new java.awt.Dimension(87, 23));

        movieComboBoxB.setModel(movieComboBoxModelB);
        movieComboBoxB.setPreferredSize(new java.awt.Dimension(87, 23));

        movieComboBoxC.setModel(movieComboBoxModelC);
        movieComboBoxC.setPreferredSize(new java.awt.Dimension(87, 23));

        movieComboBoxE.setModel(movieComboBoxModelE);
        movieComboBoxE.setPreferredSize(new java.awt.Dimension(87, 23));

        movieComboBoxD.setModel(movieComboBoxModelD);
        movieComboBoxD.setPreferredSize(new java.awt.Dimension(87, 23));

        ratingSliderA.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        ratingSliderA.setForeground(new java.awt.Color(255, 204, 0));
        ratingSliderA.setMajorTickSpacing(1);
        ratingSliderA.setMaximum(5);
        ratingSliderA.setMinimum(1);
        ratingSliderA.setMinorTickSpacing(1);
        ratingSliderA.setPaintLabels(true);
        ratingSliderA.setSnapToTicks(true);
        ratingSliderA.setValue(1);

        ratingSliderB.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        ratingSliderB.setForeground(new java.awt.Color(255, 204, 0));
        ratingSliderB.setMajorTickSpacing(1);
        ratingSliderB.setMaximum(5);
        ratingSliderB.setMinimum(1);
        ratingSliderB.setMinorTickSpacing(1);
        ratingSliderB.setPaintLabels(true);
        ratingSliderB.setSnapToTicks(true);
        ratingSliderB.setValue(1);

        ratingSliderC.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        ratingSliderC.setForeground(new java.awt.Color(255, 204, 0));
        ratingSliderC.setMajorTickSpacing(1);
        ratingSliderC.setMaximum(5);
        ratingSliderC.setMinimum(1);
        ratingSliderC.setMinorTickSpacing(1);
        ratingSliderC.setPaintLabels(true);
        ratingSliderC.setSnapToTicks(true);
        ratingSliderC.setValue(1);

        ratingSliderE.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        ratingSliderE.setForeground(new java.awt.Color(255, 204, 0));
        ratingSliderE.setMajorTickSpacing(1);
        ratingSliderE.setMaximum(5);
        ratingSliderE.setMinimum(1);
        ratingSliderE.setMinorTickSpacing(1);
        ratingSliderE.setPaintLabels(true);
        ratingSliderE.setSnapToTicks(true);
        ratingSliderE.setValue(1);

        ratingSliderD.setFont(new java.awt.Font("Roboto", 1, 13)); // NOI18N
        ratingSliderD.setForeground(new java.awt.Color(255, 204, 0));
        ratingSliderD.setMajorTickSpacing(1);
        ratingSliderD.setMaximum(5);
        ratingSliderD.setMinimum(1);
        ratingSliderD.setMinorTickSpacing(1);
        ratingSliderD.setPaintLabels(true);
        ratingSliderD.setSnapToTicks(true);
        ratingSliderD.setValue(1);

        kDummyUserSpinner.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        kDummyUserSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));

        xDummyUserSpinner.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        xDummyUserSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(kDummyUserSpinner))
                                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(xDummyUserSpinner))))
                            .addComponent(movieComboBoxE, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(ratingSliderE, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(getRecommendationsForDummyUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(movieComboBoxD, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ratingSliderD, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(movieComboBoxA, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ratingSliderA, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(movieComboBoxC, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ratingSliderC, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(movieComboBoxB, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ratingSliderB, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(movieComboBoxA, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ratingSliderA, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(movieComboBoxB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ratingSliderB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(movieComboBoxC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ratingSliderC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(movieComboBoxD, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ratingSliderD, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(movieComboBoxE, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ratingSliderE, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5))
                    .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(getRecommendationsForDummyUserButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel2Layout.createSequentialGroup()
                            .addComponent(kDummyUserSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(xDummyUserSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(51, 51, 51))
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Movie Recommends", kGradientPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private static List<Movie> getRandomTenMovie() {

      List<Movie> tenRandomMovies = new ArrayList<>();

      for (int i = 0; i < 10; i++) {
         int randomIndex = random.nextInt(movies.size());
         if (!tenRandomMovies.contains(movies.get(randomIndex))) {
            tenRandomMovies.add(movies.get(randomIndex));
         }
      }

      return tenRandomMovies;
   }

   private void showCloseMoviesButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_showCloseMoviesButtonActionPerformed
      listModel.clear();

      int userID = 0;
      if (targetUserComboBox.getSelectedItem() != null) {
         userID = targetUserComboBox.getSelectedIndex();
      }
      targetUser = targetUsers.get(userID);
      k = (int) kTargetuserSpinner.getValue();
      x = (int) xTargetUserSpinner.getValue();

      recommender = new Recommender(targetUser, k, x);

      List<Movie> movieRecommendations = recommender.getMovieRecommendations();

      for (Movie movie : movieRecommendations) {
         listModel.addElement(movie.getTitle());
      }

   }// GEN-LAST:event_showCloseMoviesButtonActionPerformed

   private int getMovieIDFromTitle(String title) {
      for (Movie movie : movies) {
         if (movie.getTitle().equals(title)) {
            return movie.getMovieID();
         }
      }
      return -1;
   }

   private void getRecommendationsForDummyUserButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_getRecommendationsForDummyUserButtonActionPerformed
      listModelDummy.clear();

      k = (int) kDummyUserSpinner.getValue();
      x = (int) xDummyUserSpinner.getValue();

      int movieAID = getMovieIDFromTitle((String) movieComboBoxA.getSelectedItem());
      int movieBID = getMovieIDFromTitle((String) movieComboBoxB.getSelectedItem());
      int movieCID = getMovieIDFromTitle((String) movieComboBoxC.getSelectedItem());
      int movieDID = getMovieIDFromTitle((String) movieComboBoxD.getSelectedItem());
      int movieEID = getMovieIDFromTitle((String) movieComboBoxE.getSelectedItem());

      HashSet<Integer> movieIDSet = new HashSet<>();
      movieIDSet.add(movieAID);
      movieIDSet.add(movieBID);
      movieIDSet.add(movieCID);
      movieIDSet.add(movieDID);
      movieIDSet.add(movieEID);

      if (movieIDSet.contains(-1) || movieIDSet.size() < 5) {
         JOptionPane.showMessageDialog(rootPane, "Please select 5 different movies");
         return;
      }

      int ratingA = ratingSliderA.getValue();
      int ratingB = ratingSliderB.getValue();
      int ratingC = ratingSliderC.getValue();
      int ratingD = ratingSliderD.getValue();
      int ratingE = ratingSliderE.getValue();

      HashMap<Integer, Integer> dummyUserRatings = new HashMap<>();
      dummyUserRatings.put(movieAID, ratingA);
      dummyUserRatings.put(movieBID, ratingB);
      dummyUserRatings.put(movieCID, ratingC);
      dummyUserRatings.put(movieDID, ratingD);
      dummyUserRatings.put(movieEID, ratingE);

      User dummyUser = new User(611, dummyUserRatings);
      for (Integer movieID : targetUsers.get(0).

              getRatings().

              keySet()) {
         if (!dummyUser.getRatings().containsKey(movieID)) {
            dummyUser.getRatings().put(movieID, 0);
         }
      }

      recommender = new

              Recommender(dummyUser, k, x);

      List<Movie> movieRecommendationsDummy = recommender.getMovieRecommendations();
      movieRecommendationsDummy.forEach(movie ->

      {
         listModelDummy.addElement(movie.getTitle());
      });

   }// GEN-LAST:event_getRecommendationsForDummyUserButtonActionPerformed

   public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            GUI log = new GUI();
            log.setLocationRelativeTo(null);
            log.setVisible(true);
         }
      });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton getRecommendationsForDummyUserButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JSpinner kDummyUserSpinner;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JSpinner kTargetuserSpinner;
    private javax.swing.JComboBox<String> movieComboBoxA;
    private javax.swing.JComboBox<String> movieComboBoxB;
    private javax.swing.JComboBox<String> movieComboBoxC;
    private javax.swing.JComboBox<String> movieComboBoxD;
    private javax.swing.JComboBox<String> movieComboBoxE;
    private javax.swing.JSlider ratingSliderA;
    private javax.swing.JSlider ratingSliderB;
    private javax.swing.JSlider ratingSliderC;
    private javax.swing.JSlider ratingSliderD;
    private javax.swing.JSlider ratingSliderE;
    private javax.swing.JList<String> recommendationsList;
    private javax.swing.JButton showCloseMoviesButton;
    private javax.swing.JComboBox<Integer> targetUserComboBox;
    private javax.swing.JSpinner xDummyUserSpinner;
    private javax.swing.JSpinner xTargetUserSpinner;
    // End of variables declaration//GEN-END:variables
}
