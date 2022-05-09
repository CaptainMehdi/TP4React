import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Routage from "./components/Routage";

function App() {
    return (
        <div>
            <div className="App-header">
                <Header title="Bibliotheque"/>
            </div>
            <Routage />
        </div>

    );
}

export default App;
