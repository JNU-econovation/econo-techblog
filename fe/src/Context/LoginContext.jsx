/* eslint-disable no-case-declarations */
/* eslint-disable import/no-extraneous-dependencies */
/* eslint-disable react/forbid-prop-types */
/* eslint-disable import/prefer-default-export */
/* eslint-disable no-unused-vars */
import React, { createContext, useReducer, useContext } from 'react';
import PropTypes from 'prop-types';

const loginInfo = {
  createdDate: '',
  emailVerified: false,
  id: -1,
  role: '',
  userEmail: '',
  userName: '',
  year: -1,
};

function loginReducer(state, action) {
  const saveData = {
    createdDate: action.createdDate,
    emailVerified: action.emailVerified,
    id: action.id,
    role: action.role,
    userEmail: action.userEmail,
    userName: action.userName,
    year: action.year,
  };
  switch (action.type) {
    case 'LOGIN':
      return saveData;
    default:
      throw Error('Unhandle Action');
  }
}

const LoginStateContext = createContext();
const LoginDispatchContext = createContext();

export function LoginProvider({ children }) {
  const [state, dispatch] = useReducer(loginReducer, loginInfo);
  return (
    <LoginStateContext.Provider value={state}>
      <LoginDispatchContext.Provider value={dispatch}>
        {children}
      </LoginDispatchContext.Provider>
    </LoginStateContext.Provider>
  );
}

export function useLoginStateContext() {
  const context = useContext(LoginStateContext);
  if (!context) {
    throw new Error('Cannot find TodoProvider');
  }
  return context;
}

export function useLoginDispatchContext() {
  const context = useContext(LoginDispatchContext);
  if (!context) {
    throw new Error('Cannot find TodoProvider');
  }
  return context;
}

LoginProvider.propTypes = {
  children: PropTypes.object.isRequired,
};
