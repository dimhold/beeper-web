<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
<title>Apache Tomcat WebSocket Examples: Chat</title>
<style type="text/css">
input#chat {
	width: 410px
}

#console-container {
	width: 400px;
}

#console {
	border: 1px solid #CCCCCC;
	border-right-color: #999999;
	border-bottom-color: #999999;
	height: 170px;
	overflow-y: scroll;
	padding: 5px;
	width: 100%;
}

#console p {
	padding: 0;
	margin: 0;
}
</style>
</head>
<body>
	<noscript>
		<h2 style="color: #ff0000">Seems your browser doesn't support
			Javascript! Websockets rely on Javascript being enabled. Please
			enable Javascript and reload this page!</h2>
	</noscript>
	<div>
		<p>
			<input type="text" placeholder="type and press enter to chat"
				id="chat">
		</p>
		<div id="console-container">
			<div id="console"></div>
		</div>
	</div>
	
	<button onclick="record();">record</button>
	<button onclick="stop();">stop</button>
	<button onclick="send();">send</button>
	
	<audio id="audio" controls="controls">

  		Your browser does not support the audio element.
	</audio>
	
	<iframe src="upload.jsp"></iframe>
	
<script type="text/javascript">
	var Chat = {};

	Chat.socket = null;

	Chat.connect = (function(host) {
		if ('WebSocket' in window) {
			Chat.socket = new WebSocket(host);
		} else if ('MozWebSocket' in window) {
			Chat.socket = new MozWebSocket(host);
		} else {
			Console.log('Error: WebSocket is not supported by this browser.');
			return;
		}

		Chat.socket.onopen = function() {
			Console.log('Info: WebSocket connection opened.');
			document.getElementById('chat').onkeydown = function(event) {
				if (event.keyCode == 13) {
					Chat.sendMessage();
				}
			};
		};

		Chat.socket.onclose = function() {
			document.getElementById('chat').onkeydown = null;
			Console.log('Info: WebSocket closed.');
		};

		Chat.socket.onmessage = function(message) {
			Console.log(message.data);
			if (message.data.indexOf("http://")==0){
				/*var source = document.getElementById('source');
				var appendNecessary = false;
				if (!source){	
					source = document.createElement('source');
					appendNecessary = true;
				}*/
				var audio = document.getElementById('audio');
				audio.pause();
				audio.src=message.data;
			    /*source.type= 'audio/ogg';
			    source.id="source";
			    source.src= message.data;
			    if (appendNecessary){
					audio.appendChild(source);
			    }*/
				audio.play();
			}
		};
	});

	Chat.initialize = function() {
		if (window.location.protocol == 'http:') {
			Chat.connect('ws://' + window.location.host
					+ '/wsocket.doo');
		} else {
			Chat.connect('wss://' + window.location.host
					+ '/wsocket.doo');
		}
	};

	Chat.sendMessage = (function() {
		var message = document.getElementById('chat').value;
		if (message != '') {
			Chat.socket.send(message);
			document.getElementById('chat').value = '';
		}
	});

	var Console = {};

	Console.log = (function(message) {
		var console = document.getElementById('console');
		var p = document.createElement('p');
		p.style.wordWrap = 'break-word';
		p.innerHTML = message;
		console.appendChild(p);
		while (console.childNodes.length > 25) {
			console.removeChild(console.firstChild);
		}
		console.scrollTop = console.scrollHeight;
	});

	Chat.initialize();
	
	
	var rec;
	function callback(stream) {
        var context = new webkitAudioContext();
        var mediaStreamSource = context.createMediaStreamSource(stream);
        rec = new Recorder(mediaStreamSource);
    }

    
    
    function record(){
    	rec.record();
    }
    
    function stop(){
    	rec.stop();
    }
    function send(){
    	var wav = rec.exportWAV();
    	//var reader = new FileReader();
    	Chat.socket.send(reader);
    }
    
</script>
</body>
</html>