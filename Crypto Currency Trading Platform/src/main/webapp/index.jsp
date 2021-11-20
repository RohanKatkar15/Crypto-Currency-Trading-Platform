<!DOCTYPE html>
<html lang="en" dir="ltr">
  
<head>
    <meta charset="ISO-8859-1">
    <title>
    HOME PAGE
    </title>
  
    <style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            height: 100vh;
            justify-content: center;
            align-items: center;
            background-color: #000;
            font-family: Times-New-Roman;
            background-video
        }
        h1 {
  text-align: center;
  padding-top: 20px;
  font-size:50px;
  font-weight:bold;
  color: #f1f9ec;
  position:absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  margin: auto;
  z-index: 3;
  max-width: 100%;
  width: 100%;
  height: 80px;
  margin-top: 0;

  background-color:#01579b;
  
}
  
        /* styling the button*/
        .btn {
            padding: 20px 20px;
            display: inline-block;
            color: black;
           
            letter-spacing: 2px;
            text-transform: uppercase;
            text-decoration: none;
            font-size: 3em;
            overflow: hidden;
            background-color:#01579b;
            
            border-radius:10px;
            margin-left: -200px;
        }
        video{
            height: 70%;
            width: 100%;
        }
  
       
        .btn:hover {
            color: #111;
            background: #29b6f6;
            box-shadow: 0 0 50px #29b6f6;
        }

        .overlay {
  width: 100%;
  height: 100vh;
  position: absolute;
  top: 0;
  left: 0;
  background-size: 3px 3px;
  z-index: 2;
}

video {
  min-width: 100%;
  min-height: 100vh;
  z-index: 1;
}

.bg-video-wrap {
  position: relative;
  overflow: hidden;
  width: 100%;
  height: 100vh;
  }
form {

  color: #fff;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  margin: auto;
  z-index: 3;
  max-width: 400px;
  width: 100%;
  height: 50px;
}
#id{
    
    margin-right:-100px; 
}
#ha{
    margin-right: 10px;
}
video {
  object-fit: cover;
  width: 100vw;
  height: 100vh;
  position: fixed;
  top: 0;
  left: 0;
}
h1 img{
float : left;
width:100px;
height:80px;
margin-top:-10px;
margin-left:10px;
}

        
    </style>
</head>


<body>
  <h1><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Ethereum-icon-purple.svg/1200px-Ethereum-icon-purple.svg.png"></img>Crypto Trade</h1>
  
  <div class="bg-video-wrap">
    <video src="https://dm0qx8t0i9gc9.cloudfront.net/watermarks/video/HGea1gV2isztpyql/videoblocks-bitcoin-btc-coin-and-ethereum-eth-coins-rotating-on-bills-of-100-dollars_hnsafjapf__147ddf16e8b4001c8d18c8e7c05e53b5__P360.mp4" loop muted autoplay>
    </video>
    <div class="overlay">
    </div>
    
 <form action="employeeregister.jsp" id="ro">
 <button type="submit" value="Submit" class="btn btn-primary btn-block btn-large" id="ro">Sign Up</button>

</form>


<form action="login.jsp" id="ha">
 <button type="submit" value="Submit" class="btn btn-primary btn-block btn-large">Sign in</button></form>
  </div>

</body>
  
</html>