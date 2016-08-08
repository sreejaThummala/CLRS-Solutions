Push notification:
	Push notifications let your application notify a user of new messages or events when the user is not actively using your app
Components:
	Event generation
	Event targeting
	Message delivery
Event Generation
	Event generation happens with response to a request to application. 
		It shouldnot increase latency of response
			If any processing can be done out of band, it should be done.
				A light weight write to redis queue
				Process events from queue
Event targeting phase
	Get the events from the queue
	Rehydrate the data
	Do some notification logic
Message delivery
	APNS - Apple push notification service
	Use pub/sub functionality fo Redis
	Publish data to redis channel
	node.js worker is waiting to act upon it
	node.js pushes the data to notification service

Concerns:
	Availability /Scalability
		Is one node.js worker enough?
			what if node.js worker crashes?
			publish the data to redis sharded channel(pub/sub)
			each node.js is subscribed to a sharded channel.
				Advantages:
					It scales well horizontally
	Is redis pub/sub 100% available?
		mutliple hosts each serving as backup to one another
		coordinated by redis global lock
		
