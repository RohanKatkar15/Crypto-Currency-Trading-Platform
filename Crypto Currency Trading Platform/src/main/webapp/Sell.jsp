<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title></title>
  <style type="text/css">
  	@import url(https://fonts.googleapis.com/css?family=Open+Sans);
  *,
*::after,
*::before {
  margin: 0;
  padding: 0;
  box-sizing: inherit;
  font-size: 62,5%;
  margin-left: 22px;
  margin-top: 200px;
}
   html, body {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 100%;
  background: #2c3e50;
  font-family: 'Montserrat', sans-serif;
  font-size: 16px;
}

body {
  height: 100vh;
  width: 100%;
  background: #0f2027; /* fallback for old browsers */
  background: linear-gradient(to right,#2c5364, #203a43, #0f2027);
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  color: #fff;
}
body {
  display: -webkit-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-flex-wrap: wrap;
      -ms-flex-wrap: wrap;
          flex-wrap: wrap;
  
      -ms-flex-pack: distribute;
          
  -webkit-box-align: center;
  -webkit-align-items: center;
      -ms-flex-align: center;
          align-items: center;
  -webkit-align-content: center;
      -ms-flex-line-pack: center;
          align-content: center;
}

.form__label {
  font-family: 'Roboto', sans-serif;
  font-size: 1.2rem;
  margin-left: 2rem;
  margin-top: 0.7rem;
  display: block;
  transition: all 0.3s;
  transform: translateY(0rem);
}

.form__input {
  font-family: 'Roboto', sans-serif;
  color: #333;
  font-size: 1.2rem;
  margin: 0 auto;
  padding: 1.5rem 2rem;
  border-radius: 0.2rem;
  background-color: rgb(255, 255, 255);
  border: none;
  width: 90%;
  display: block;
  border-bottom: 0.3rem solid transparent;
  transition: all 0.3s;
}

.form_input:placeholder-shown + .form_label {
  opacity: 0;
  visibility: hidden;
  -webkit-transform: translateY(-4rem);
  transform: translateY(-4rem);
}
h1 {
  color: #f1c40f;
  font-size: 3rem;
  text-transform: uppercase;
  display: block;
  width: 100%;
  text-align: center;
}
div h1{
  margin-bottom: 220px;
  margin-top: -100px;
}
@media screen and (max-width: 600px) {
  h1 {
    font-size: 3rem;
  }
}

p {
  color: #f1c40f;
  font-size: 1.2rem;
  width: 100%;
  padding: 20px;
  text-align: center;
}

.btn {
  box-sizing: border-box;
  -webkit-appearance: none;
     -moz-appearance: none;
          appearance: none;
  background-color: transparent;
  border: 2px solid #e74c3c;
  border-radius: 0.6em;
  color: #e74c3c;
  cursor: pointer;
  display: -webkit-box;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-align-self: center;
      -ms-flex-item-align: center;
          align-self: center;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1;
  margin: 20px;
  padding: 1.2em 2.8em;
  text-decoration: none;
  text-align: center;
  text-transform: uppercase;
  font-family: 'Montserrat', sans-serif;
  font-weight: 700;
}
.btn:hover, .btn:focus {
  color: #fff;
  outline: 0;
}

.third {
  border-color: #3498db;
  color: #fff;
  box-shadow: 0 0 40px 40px #3498db inset, 0 0 0 0 #3498db;
  -webkit-transition: all 150ms ease-in-out;
  transition: all 150ms ease-in-out;
  float: left;

}
.third:hover {
  box-shadow: 0 0 10px 0 #3498db inset, 0 0 10px 4px #3498db;
}
#move{
  margin-top: 100px;
  margin-right: 400px;
  margin-left: 450px;
}
#mo{
  margin-right: 200px;
}

  </style>
</head>
<body  style="background-image: url('https://wallpapercave.com/wp/wp2322106.jpg">

<div class="form__group">
<form action="<%= request.getContextPath() %>/BuyServlet1" method="POST">
  <input type="text" class="form__input" name="cc" placeholder="NUMBER OF ETHERUM WOULD YOU LIKE TO BUY" required="required" />
  <label for="name" class="form__label">NUMBER OF ETHERUM WOULD YOU LIKE TO SELL</label>
  <button type ="submit" value="submit" class="btn third" id="mo">SELL</button>
  </form>
</div>

</body>
</html>