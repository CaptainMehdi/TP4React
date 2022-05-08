import logo from './logo.svg';
import './App.css';
import Header from './app/components/Header';
import Routage from "./app/components/Routage";

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
