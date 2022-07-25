import React, { useState } from 'react';

import FindIDBox from './FindIDBox';
import SuccessFindId from './SuccessFindId';

import './css/FindID.css';

function FindID() {
  const [isFindID, setIsFindID] = useState(false);
  const [user, setUser] = useState({
    email: '',
    name: '',
  });

  return (
    <div className="find-id">
      {isFindID ? (
        <SuccessFindId email={user.email} name={user.name} />
      ) : (
        <FindIDBox setIsFindID={setIsFindID} setUser={setUser} />
      )}
    </div>
  );
}

export default FindID;
