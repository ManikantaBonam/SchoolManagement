<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
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
        <h1>Admin Dashboard</h1>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link active" href="AddClass.html">Add Class</a>
            </li>
           <!--  <li class="nav-item">
                <a class="nav-link" href="AddSection.html">Add Section</a>
            </li> -->
            <li class="nav-item">
                <a class="nav-link" href="ViewServlet">View Classes</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ViewStudentServlet">View Students</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="LogoutServlet">LogOut</a>
            </li>
        </ul>
    </nav>
    <div class="content">
        <div class="welcome-msg">
            <h2>Welcome <%= session.getAttribute("username") %>...!!!!</h2>
        </div>
        <div class="quotation">
            <p>"Knowledge is a process of piling up facts; wisdom lies in their simplification."</p>
        </div>
        <div class="quotation">
            <p>"The function of education is to teach one to think intensively and to think critically. Intelligence plus character – that is the goal of true education."</p>
        </div>
        <div class="quotation">
            <p>"Education must enable one to sift and weigh evidence, to discern the true from the false, the real from the unreal, and the facts from the fiction."</p>
        </div>
        <div class="quotation">
            <p>"We must remember that intelligence is not enough. Intelligence plus character-that is the goal of true education. The complete education gives one not only power of concentration, but worthy objectives upon which to concentrate."</p>
        </div>
    </div>
</body>
</html>
