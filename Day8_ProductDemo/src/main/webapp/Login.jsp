<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f9fc;
        margin: 0;
        padding: 0;
    }
    .login-container {
        width: 350px;
        margin: 80px auto;
        background-color: #fff;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        position: relative;
        z-index: 1;
    }
    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }
    label {
        display: block;
        margin-bottom: 8px;
        font-weight: bold;
        color: #555;
    }
    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ddd;
        border-radius: 5px;
        font-size: 14px;
    }
    button {
        width: 100%;
        padding: 12px;
        background-color: #007BFF;
        color: #fff;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }
    button:hover {
        background-color: #0056b3;
    }

    /* Loader overlay */
 .overlay {
    display: none;
    position: fixed;
    top: 0; left: 0;
    width: 100%; height: 100%;
    background: rgba(255,255,255,0.7); /* fallback */
    backdrop-filter: blur(5px);        /* blur effect */
    -webkit-backdrop-filter: blur(5px); /* Safari support */
    z-index: 9999;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    .spinner {
        border: 8px solid #f3f3f3;
        border-top: 8px solid #007BFF;
        border-radius: 50%;
        width: 60px;
        height: 60px;
        animation: spin 1s linear infinite;
    }
    @keyframes spin {
        0% { transform: rotate(0deg); }
        100% { transform: rotate(360deg); }
    }
    .loading-text {
        margin-top: 15px;
        font-size: 18px;
        color: #333;
    }
</style>
<script>
function showLoader() {
    document.getElementById("overlay").style.display = "flex";
    // simulate delay for testing
    setTimeout(() => {
        document.forms[0].submit();
    }, 2000);
    return false; // prevent immediate submit
}
</script>
</head>
<body>
    <div class="login-container">
        <h2>User Login</h2>
        <form action="validateuser" method="post" onsubmit="return showLoader()">
            <label for="uname">Username</label>
            <input type="text" id="uname" name="uname" placeholder="Enter username" required />

            <label for="pass">Password</label>
            <input type="password" id="pass" name="pass" placeholder="Enter password" required />

            <button type="submit" id="btn" name="btn">Login</button>
        </form>
    </div>

    <!-- Loader overlay -->
    <div id="overlay" class="overlay">
    <div class="spinner"></div>
    <div class="loading-text">Logging in, please wait...</div>
</div>
</body>
</html>