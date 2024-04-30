<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student DashBoard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }
        .sidebar {
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            width: 250px;
            background-color: #007bff;
            padding-top: 20px;
            padding-right: 15px;
            color: #ffffff;
        }
        .sidebar h1 {
            color: #ffffff;
            text-align: center;
        }
        .sidebar .nav-link {
            color: #ffffff;
            padding: 10px 15px;
        }
        .sidebar .nav-link:hover {
            background-color: #0056b3;
        }
        .content {
            margin-left: 250px;
            padding: 20px;
            text-align: center;
        }
        .content .welcome-msg {
            background-color: #f0f0f0; 
            border-radius: 8px; 
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 30px;
        }
        .quotation {
            margin-top: 40px;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
    </style>
 
</head>
<body>
  <nav class="sidebar">
   <h1>Student Dashboard</h1>
   <ul class="nav flex-column">
            <li class="nav-item">
             <a class="nav-link active" href="ViewMyServlet">View My Details</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="LogoutServlet">LogOut</a>
            </li>
    </ul>
</nav>
<div class="content">
        <div class="welcome-msg">
            <h2>Welcome <%= session.getAttribute("username") %>...!!!!</h2>
        </div>
        <div class="quotation">
            <p>"Vitally important for a young man or woman is, first, to realize the value of education and then to cultivate earnestly, aggressively, ceaselessly, the habit of self-education."</p>
        </div>
          <div class="quotation">
          <p>"I came to understand the value of education, not just to enable me to make a good living, but to enable me to make a worthwhile life."</p>
          </div>
          <div class="quotation">
          <p>"The object of education is to prepare the young to educate themselves throughout their lives."</p>
          </div>
          <div class="quotation">
          <p>"Next in importance to freedom and justice is popular education, without which neither freedom nor justice can be permanently maintained."</p>
          </div>
     </div>
</body>
</html>

