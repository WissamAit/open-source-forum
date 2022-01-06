import "./login.css";
import { useHistory } from "react-router-dom";
import { useState } from "react";

const Login = () => {
  const [username, setUsername] = useState("");
  const history = useHistory();

  const handleSubmit = (event) => {
    event.preventDefault();
    username &&
      history.push({
        pathname: "wall",
        search: `?username=${username}`,
        state: {
          // location state
          update: true,
        },
      });
  };

  const handleChange = (event) => {
    setUsername(event.target.value);
  };

  return (
    <div class="body">
      <div class="containerLogin" style={{ marginTop: "10rem" }}>
        <div class="d-flex justify-content-center h-100">
          <div
            class="card cardLogin"
            style={{ width: "25rem", height: "15rem" }}
          >
            <div class="card-header">
              <h3 style={{ marginTop: "1rem" }}>Choose a username</h3>
              <div class="d-flex justify-content-end social_icon">
                <span>
                  <i class="fa fa-facebook-square"></i>
                </span>
                <span>
                  <i class="fa fa-google-plus-square"></i>
                </span>
                <span>
                  <i class="fa fa-twitter-square"></i>
                </span>
              </div>
            </div>
            <div class="card-body">
              <form
                className="needs-validation"
                onSubmit={handleSubmit}
                noValidate
              >
                <div class="input-group form-group">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="fa fa-user"></i>
                    </span>
                  </div>
                  <input
                    value={username}
                    onChange={handleChange}
                    type="text"
                    class="form-control"
                    placeholder="username"
                    required
                  />
                </div>
                <div class="form-group" style={{ textAlign: "center" }}>
                  <button type="submit" class="btn btn-info">
                    Login
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
