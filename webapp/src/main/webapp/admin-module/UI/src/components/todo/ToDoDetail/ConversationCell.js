<<<<<<< HEAD
<<<<<<< HEAD
import React from 'react';

const ConversationCell = ({conversation}) => {
  return (
    <div className="d-flex module-detail-item">
      <div className="chat-todo-avatar">

        <img className="rounded-circle avatar size-40" src={conversation.thumb}
             alt="..."/>
      </div>
      <div className="chat-toto-info">
        <div className="d-flex  flex-column">
          <div className="name mr-2">{conversation.name}</div>
          <div className="time text-muted">{conversation.sentAt}</div>
        </div>
        <div className="message">{conversation.message}</div>
      </div>
    </div>
  )
};

=======
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
import React from 'react';

const ConversationCell = ({conversation}) => {
  return (
    <div className="d-flex module-detail-item">
      <div className="chat-todo-avatar">

        <img className="rounded-circle avatar size-40" src={conversation.thumb}
             alt="..."/>
      </div>
      <div className="chat-toto-info">
        <div className="d-flex  flex-column">
          <div className="name mr-2">{conversation.name}</div>
          <div className="time text-muted">{conversation.sentAt}</div>
        </div>
        <div className="message">{conversation.message}</div>
      </div>
    </div>
  )
};

<<<<<<< HEAD
>>>>>>> 4d2bbb9... backbone for the dashboard
=======
>>>>>>> 4d2bbb99f7304fe93e114a6909260496de0e6fc0
export default ConversationCell;