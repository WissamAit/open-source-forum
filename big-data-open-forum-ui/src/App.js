import React from "react";
import "./App.css";
import Login from "./components/login/Login";
import Wall from "./components/wall/Wall";
import { BrowserRouter as Routes, Route, Switch } from "react-router-dom";

function App() {
  return (
    <Routes>
      <Switch>
        <Route path="/wall">
          <Wall />
        </Route>
        <Route path="/login">
          <Login />
        </Route>
        <Route path="*">
          <Login />
        </Route>
      </Switch>
    </Routes>
  );
}

export default App;
