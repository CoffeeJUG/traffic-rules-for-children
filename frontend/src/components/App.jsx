import React from 'react';
import {BrowserRouter, Route} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.css';
import Navbar from './Navbar/Navar';
import Map from './pages/Map/Map';
import Pazzle from "./pages/Pazzle/Pazzle";
import BestPlayers from "./pages/BestPlayers/BestPlayers";
import Profile from "./pages/Profile/Profile";
import MainPage from "./pages/MainPage/MainPage";
import Cookies from 'js-cookie';
// cookie set exmpl
// Cookies.set('green-light_profile', 
// 	{
// 	"name" : "Irusya",
// 	"completedLevel" : 5,
// 	"mistakes" : 3,
// 	"fullscreen" : 1,
// 	"progress" : 2,
// 	}
// );

// console.log(JSON.parse(Cookies.get('puzzle-kid-game')).fullscreen);
let game = {
	pazzles: {
		0:{
			name: '1',
			task: 'select',
			description: 'Обери знак, який дозволяє безпечно перейти дорогу.',
			styles: {
				left: 1240,
				top: 504 
			}
		},
		1:{
			name: '2',
			task: 'select',
			description: 'Обери знак, який дозволяє безпечно перейти дорогу2.',
			styles: {
				left: 1570,
				top: 504 
			}
		},
	},
	player: {
		progress: '3',
	}
}

function App() {
  return (
      <BrowserRouter>
        <div>
            <Navbar />
            <Route path='/mainPage' component={MainPage}/>
              <Route path='/map' render={(props) => (
              	<Map {...props}
              		pazzles={game.pazzles}
              		progress={game.player.progress}
              	/>
              )}/>
              <Route path='/pazzle' render={(props) => (
			    <Pazzle {...props} 
			    />
			  )}/>
              {/*Will use pazzle as main component for all pazzles*/}
              {/*<Route path='/pazzle-1' component={Pazzle1}/>*/}
              <Route path='/bestPlayers' component={BestPlayers}/>
              <Route path='/profile' component={Profile}/>
        </div>
      </BrowserRouter>
  );
}
export default App;
