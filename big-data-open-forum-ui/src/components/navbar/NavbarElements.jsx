import React from "react";
import styled from "styled-components";
import { NavLink as Link } from "react-router-dom";
import { FaBars } from "react-icons/fa";

export const Nav = styled.nav`
  background: #000;
  opacity: 0.6;
  height: 80px;
  display: flex;
  justify-content: space-between;
  padding: 1rem calc((80vw - 1000px) / 2);
  z-index: 1000;
`;
export const NavLink = styled(Link)`
  color: #fff;
  display: flex;
  justify-content: space-between;
  align-items: center;
  text-decoration: none;
  padding: 0 1rem;
  height: 100%auto;
  cursor: pointer;

  &.active {
    color: #15cdfc;
  }
`;
export const Bars = styled(FaBars)`
  display: none;
  color: #fff;

  @media screen and (max-width: 768px) {
    display: block !important;
    position: absolute;
    top: 0;
    right: 0;
    transform: translate(-100%, 75%);
    font-size: 1.8rem;
    cursor: pointer;
  }
`;
export const NavMenu = styled.div`
  display: flex !important;
  align-items: center;
  margin-right: -24px;

  @media screen and (max-width: 768px) {
    display: none;
  }
`;
export const NavBtn = styled.nav`
  display: flex;
  align-items: center !important;
  margin-right: 24px;

  @media screen and (max-width: 768px) {
    display: none;
  }
`;

export const NavBtnLink = styled(Link)`
  border-radius: 4px;
  background: #256ce1;
  padding: 10px 22px;
  color: #fff;
  outline: none;
  border: none;
  cursor: pointer;
  transition: all 0.2s ease-in-out;
  text-decoration: none;
  /* Second Nav */
  margin-left: 24px;
  &:hover {
    transition: all 0.2s ease-in-out;
    background: #fff;
    color: #010606;
  }
`;
