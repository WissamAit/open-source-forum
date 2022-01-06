import React from "react";
import { Nav, NavLink } from "./NavbarElements";

const NavbarWall = () => {
  return (
    <>
      <Nav>
        <NavLink to="/login">
          <img
            style={{
              height: "100px",
              width: "150px",
              marginLeft: "1px",
              marginTop: "20%",
            }}
            src={"https://lte.ma/wp-content/uploads/2015/09/big-data1.png"}
            alt=""
          />
        </NavLink>
      </Nav>
    </>
  );
};
export default NavbarWall;
